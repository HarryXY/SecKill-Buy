package org.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @author xuyi
 *
 */
public interface SuccessKilledDao {

	
	/**
	 * insert purchase detail
	 * @param secKillId
	 * @param userPhone
	 * @return insert row number
	 * when there are many parameters, need to use @Param
	 */
	int insertSuccessKilled(@Param("secKillId")long secKillId, @Param("userPhone")long userPhone);
	
	
	/**
	 * retrieve SuccessKilled with secKillId
	 * @param secKillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId, @Param("userPhone")long userPhone);
	
	
}
