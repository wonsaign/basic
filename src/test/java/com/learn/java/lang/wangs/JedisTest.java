package com.learn.java.lang.wangs;

import junit.framework.TestCase;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

public class JedisTest extends TestCase{

	public static void main(String[] args) {
		
		Jedis jedis = getByNum(2);
		setList(jedis);
		
		jedis.save();// RDB持久化,已经废弃
		jedis.bgsave();// RDB主要的使用方式
		
		jedis.bgrewriteaof();// AOF持久化方式
		tranTest(jedis);
		// pipeTest(jedis);
	}
	// DB 默认
	public static Jedis getDefault() {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		return jedis;
	}
	public static Jedis getByNum(int num) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.select(num);
		return jedis;
	}
	static void setList(Jedis jedis) {
		jedis.lpush("list", "1","2","3");
		jedis.rpush("list", "1","2","3");
	}
	static void setKVS(Jedis jedis) {
		String[] keysvalues = {"k1","v1","k2","v2","k3","v3"};
		jedis.mset(keysvalues);
	}
	static void setString(Jedis jedis) {
		String random = String.valueOf((int)((Math.random()*9+1)*100000));
		jedis.set("18012345678", random, "NX", "EX", 60);
		jedis.set("18087654321",random);
	}
	static void incre(Jedis jedis) {
		jedis.incrBy("incr",2L);
	}
	// 事务
	@SuppressWarnings("unused")
	static void tranTest(Jedis jedis) {
		try {
			Transaction t =	jedis.multi();// begin
			t.set("transation", "");
			t.lpush("QQ", "55");  
			int make_error = 1 / 0; 
			t.lpush("QQ", "66");  
			t.exec();// 结束
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// 管道
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
