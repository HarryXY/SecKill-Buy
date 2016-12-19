package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

/**
 * interface: design on "user" view
 * 3 aspects: particle size + parameters, return values
 * @author xuyi
 *
 */
public interface SeckillService {
	
	/**
	 * retriev all the seckill records
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * retrieve onr record by id
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * when seckill starts, export interface address
	 * otherwise exports sys time and seckill time
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * execute seckill command
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) 
			throws SeckillException, RepeatKillException, SeckillCloseException;
	
	SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);

}
