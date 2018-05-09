package com.learn.java.lang.wangs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

// 扫描所有的CD
//@ComponentScan(basePackages="com/learn/java/lang/wangs/spring/impl")
//@Configuration
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@PropertySource(value = { "classpath:config.propertities" })

public class CDplayer {
	@Autowired
	Environment env;
	
	void say() {
		env.getProperty("CD.name");
		env.getProperty("CD.date");
	}
}
