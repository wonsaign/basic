package com.learn.java.lang.wangs.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TestSpring implements ApplicationContextAware{
	@Autowired
	private static CDplayer player;
	@Autowired
	@SuppressWarnings("unused")
	private static ApplicationContext app;
	
	public static void main(String[] args) {
		// 容器都没启动 ，当然是空的，吗的智障。。。
		player.say();
	}

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.app = applicationContext;
	}
}
