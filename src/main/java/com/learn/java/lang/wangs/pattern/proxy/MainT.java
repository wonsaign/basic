package com.learn.java.lang.wangs.pattern.proxy;

import java.lang.reflect.Proxy;

import javax.crypto.spec.IvParameterSpec;

public class MainT {
	
	public static void main(String[] args) {
		// 动态代理
//		Test t = new TestImpl();
//		MyInvo in = new MyInvo(t);
//		Test p =  (Test)Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), in);
//		p.hello();
		// 代理
		DynProxy.newMapperProxy(Test.class).hello();
	}
}
