package org.seckill.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//configurations needed to be loaded
@ContextConfiguration({"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;

	@Test
	public void testGetSeckillList() {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}", list);
	}

	@Test
	public void testGetById() {
		long seckillId = 1001;
		Seckill seckill = seckillService.getById(seckillId);
		logger.info("seckill={}", seckill);
	}

	@Test
	public void testSeckillLogic() {
		long seckillId = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		
		if(exposer.isExposed()){
			logger.info("exposer={}", exposer);
			long userPhone = 15057018899L;
			String md5 = exposer.getMd5();
			try{
				SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
				logger.info("seckillExecution={}", seckillExecution.toString());	
			}catch(RepeatKillException e){
				logger.error(e.getMessage());;
			}catch(SeckillCloseException e){
				logger.error(e.getMessage());;
			}		
		}else{
			//seckill not start
			logger.warn("exposer={}", exposer);
		}
	}
	
	@Test
	public void executeSeckillProcedure(){
		long seckillId = 1000;
		long phone = 13588886666L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			String md5 = exposer.getMd5();
			SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
			logger.info(execution.getStateInfo());
		}
	}


}
