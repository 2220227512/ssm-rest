package com.taotao.rest.redis;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.dao.impl.JedisClientSingle;


public class TestRedis {
	@Test
	public void testSpringJedisSingle() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisClient jides= (JedisClient) applicationContext.getBean("jedisClient");
		jides.hset("test", "k1", "v1");
	}
	
	@Test
	public void testSpringJedisSingle2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisClientSingle jides= (JedisClientSingle) applicationContext.getBean("jedisClient");
		String vString=jides.hget("hke1", "k1");
		System.out.println(vString);
	}

	@Test
	public void testSpringJedisSingle3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
		Jedis jedis = pool.getResource();
		String string = jedis.hget("hke1", "k1");
		System.out.println(string);
		jedis.close();
		pool.close();
	}
	
	@Test
	public void testSpringJedisSingle4() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
		Jedis jedis = pool.getResource();
		jedis.hset("hke1", "k1", "hv1");
				
		//System.out.println(string);
		jedis.close();
		pool.close();
	}
	
	@Test
	public void run(){
		System.out.println("cccccccccc");
	}
	
	
	@Test
	public void testJedisPool() {
		//创建jedis连接池
		JedisPool pool = new JedisPool("192.168.190.128", 6379);//
		//从连接池中获得Jedis对象
		Jedis jedis = pool.getResource();
		String string = jedis.get("key1");
		System.out.println(string);
		//关闭jedis对象
		jedis.close();
		pool.close();
	}



}
