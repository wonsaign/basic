package com.learn.java.lang.wangs;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

public class JedisTest extends TestCase{

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("127.0.0.1",6379);
		String random = String.valueOf((int)((Math.random()*9+1)*100000));
		jedis.set("18012345678", random, "NX", "EX", 60);
		jedis.set("18087654321",random);
		String[] keysvalues = {"k1","v1","k2","v2","k3","v3"};
		jedis.mset(keysvalues);
		jedis.incrBy("incr",2L);
		
		jedis.lpush("list", "1","2","3");
		jedis.rpush("list", "1","2","3");
		
		Map<String,String> map = new HashMap<>();
		
		tranTest(jedis);
		pipeTest(jedis);
	}
	static void tranTest(Jedis jedis) {
		Transaction t =	jedis.multi();// begin
		t.set("transation", "");
		t.exec();// 结束
	}
	static void pipeTest(Jedis jedis) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			jedis.set(String.valueOf(i), "test");
		}
		long end = System.currentTimeMillis();
		System.out.println("cost:"+(end - begin)); 
		 
		long start_pipe = System.currentTimeMillis();
		Pipeline pipe = jedis.pipelined();
		for (int i = 0; i < 10000; i++) {
			pipe.set(String.valueOf(i), "test");
		}
		pipe.sync();
		long end_pipe = System.currentTimeMillis();
		System.out.println("cost:"+(end_pipe - start_pipe)); 
	}
	
}
