package org.seckill.enums;

/**
 * use enum to express constant
 * @author xuyi
 *
 */
public enum SeckillStateEnum {
	
	SUCCESS(1,"Seckill succeed"),
	END(0,"seckill Closed"),
	REPEAT_KILL(-1,"Seckill Repeated"),
	INNER_ERROR(-2,"System Exception"),
	DATA_REWRITE(-3,"Data Rewrite"),
	NOT_LOGIN(-4,"Not Login");
	
	
	private int state;
	
	private String stateinfo;
	
	private SeckillStateEnum(int state, String stateinfo) {
		this.state = state;
		this.stateinfo = stateinfo;
	}

	public int getState() {
		return state;
	}

	public String getStateinfo() {
		return stateinfo;
	}

	public static SeckillStateEnum stateOf(int index){
		for(SeckillStateEnum state : values()){
			if(state.getState() == index){
				return state;
			}
		}
		return null;
	}
	
}
