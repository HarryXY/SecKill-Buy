package org.seckill.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

/**
 * 
 * @author xuyi
 *
 */
public interface SeckillDao {

	//reduce inventory
	/**
	 * @param seckillId
	 * @param killTime
	 * @return updated row number
	 */
	int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);
	
	//query by id
	/**
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	//query all
	/**
	 * @param offset
	 * @param limit
	 * @return
	 * java dosn't instore formal parameters, need to use @Param("")
	 */
	List<Seckill> queryAll(@Param("offset")int offset, @Param("limit")int limit);
	
	/**
	 * use database procedure 
	 * @param paramMap
	 */
	void killByProcedure(Map<String, Object> paramMap);
}
