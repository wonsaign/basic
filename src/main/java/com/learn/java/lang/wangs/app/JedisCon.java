package com.learn.java.lang.wangs.app;

import redis.clients.jedis.Jedis;

public class JedisCon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Jedis jd = new Jedis("192.168.227.132:22", 6379);
		jd.set("hello", "world");
		System.out.println(jd.get("hello"));
	}

}