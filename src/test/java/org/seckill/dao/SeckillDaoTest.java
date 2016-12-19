package org.seckill.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * configure integration of spring&junit, load spring IOC container when junit starts
 * @author xuyi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest{

	@Resource
	private SeckillDao seckillDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testReduceNumber() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int updateCount = seckillDao.reduceNumber(1001L, sdf.parse("2016-11-12"));		
		System.out.println(updateCount);
	}

	@Test
	public void testQueryById() {
		Seckill seckill = seckillDao.queryById(1000);
		System.out.println(seckill.getNumber());
		assertEquals("$1000 secKill iphone7", seckill.getName());
	}

	@Test
	public void testQueryAll() {
		List<Seckill> seckillList = seckillDao.queryAll(0,100);
		System.out.println(seckillList.toString());
	}
}
