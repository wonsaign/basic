package com.learn.java.lang.wangs;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.java.lang.wangs.spring.CDplayer;

public class SpringCD {

	@Autowired
	private CDplayer player;
	
	public SpringCD(){
//		ApplicationContext app = new FileSystemXmlApplicationContext("/src/test/resource/application.xml");
//		player = app.getBean(CDplayer.class);
	}
	
	@Test
	public void test() {
		
	}

}
