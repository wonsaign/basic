package com.learn.java.lang.wangs.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvo implements InvocationHandler{
	
	private Object obj;
	
	public MyInvo(Object obj) {
		this.obj = obj;
	}
		

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理开始");
		method.invoke(obj, args);
		System.out.println("代理结束");
		return null;
	}

}
