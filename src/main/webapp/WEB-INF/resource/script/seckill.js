//interaction logic js code
//encapsulation
var seckill ={
	//encapsulate ajax url
	URL:{
		now: function(){
			return '/seckill/time/now';
		},
		exposer: function(seckillId){
			return '/seckill/' + seckillId +'/exposer';
		},
		execution: function(seckillId, md5){
			return '/seckill/' + seckillId + '/' + md5 + '/execution';
		}
	},
	
	handleSeckillkill: function(seckillId, node) {
		node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">Begin Seckill</button>');
		$.post(seckill.URL.exposer(seckillId), {}, function(result){
			if(result && result['success']){
				var exposer = result['data'];
				if(exposer['exposed']){
					//open seckill
					//get seckill URL
					var md5 = exposer['md5'];
					var killUrl = seckill.URL.execution(seckillId, md5);
					console.log("killUrl:" + killUrl);
					//bind one click
					$("#killBtn").one("click", function() {
						//execute seckill
						//1:disable button
						$(this).addClass('disabled');
						//2:send seckill request
						$.post(killUrl, {}, function(result) {
							if(result && result['success']){
								var killResult = result['data'];
								var state = killResult['state'];
								var stateInfo = killResult['stateInfo'];
								//3:show result
								node.html('<span class="label label-success">'+ stateInfo +'</span>');
							}
						});
					});
					node.show();
				}
			}else{
				 var now = exposer['now'];
                 var start = exposer['start'];
                 var end = exposer['end'];
                 seckill.countDown(seckillId, now, start, end);
			}
		});
	},
	
	//validate phone number
	validatePhone: function(phone){
		if(phone && phone.length == 11 && !isNaN(phone)){
			return true;
		}else{
			return false;
		}
	},
	
	countdown: function(seckillId, nowTime, startTime, endTime){
		var seckillBox = $("#seckill-box");
		if(nowTime > endTime){
			//Seckill is Over!
			seckillBox.html('Seckill is Over!');
		}else if(nowTime < startTime){
			//not start yet
			var killTime = new Date(startTime + 1000);
			seckillBox.countdown(killTime, function(event) {
				//time format
				var format = event.strftime('Countdown: %D days %H hours %M minutes %S seconds');
				seckillBox.html(format);
			}).on('finish.countdown', function(){
				//get seckill URL, control display logic, execute seckill
				seckill.handleSeckillkill(seckillId, seckillBox);
			});
		}else{
			//in the process
			 seckill.handleSeckillkill(seckillId, seckillBox);
		}
	},
	
	//detail page seckill logic
	detail:{
		//initiate
		init:function(params){
			//phone number invalidate and login, time interation
			//plan interaction logic
			//cookie data(phone)
			var killPhone = $.cookie('killPhone');
			
			//validate phone number
			if(!seckill.validatePhone(killPhone)){
				var killPhoneModal = $('#killPhoneModal');
				//dispaly pop layer
				killPhoneModal.modal({
					show:true,//dispaly pop layer
					backdrop:'static',//forbidden layer close
					keyboard:false // forbidden keyboard					
				});	
				$('#killPhoneBtn').click(function(){
					var inputPhone = $('killPhoneKey').val();
					if(seckill.validatePhone(inputPhone)){
						//write phone into cookie
						$.cookie('killPhone', input, {expires:7, path:'/seckill'});
						windows.location.reload();
					}else{
						$('#killPhoneMessage').hide().html('<lable class="label label-danger">Wrong Phnoe Number</label>');
					}
				});
			}
			
			//Logined
			var startTime = params['startTime'];
			var entTime= params['endTime'];
			var seckillId = params['seckillId'];
			$.get(seckill.URL.now(), {}, function(result){
				if(result && result['success']){
					var nowTime = result['data'];
					//time decision
					seckill.countdown(seckillId, nowTime, startTime, endTime);
					
				}else{
					console.log('result:' + result);
				}
			});
			
		}
	}
}