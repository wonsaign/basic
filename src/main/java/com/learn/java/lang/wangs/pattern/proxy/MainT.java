package com.learn.java.lang.wangs.pattern.proxy;

import java.lang.reflect.Proxy;

public class MainT {
	
	public static void main(String[] args) {
		// 动态代理
//		Test testImpl = new TestImpl();
//		MyInvo invocationHandlerMyImpl = new MyInvo(testImpl);
//		Test p =  (Test)Proxy.newProxyInstance(testImpl.getClass().getClassLoader(), testImpl.getClass().getInterfaces(), invocationHandlerMyImpl);
//		p.hello();
		/**
		 * 主要原理是：反射
		 * Proxy.newProxyInstance 是java动态代理类要调用的静态方法
		 * 参数1，被代理的接口的具体实现类的类加载器
		 * 参数2，被代理的接口的具体实现类集合
		 * 参数3，接口InvocationHandler的具体实现者，也就是代理类中需要开发人员自定实现的代理部分
		 */
//		Test pwrong =  (Test)Proxy.newProxyInstance(Test.class.getClassLoader(),Test.class.getInterfaces(), new MyInvo(new TestImpl()));
//		Test p1 =  (Test)Proxy.newProxyInstance(TestImpl.class.getClassLoader(),TestImpl.class.getInterfaces(), new MyInvo(new TestImpl()));
//		p1.hello();
		// 代理
//		DynProxy.newMapperProxy(TestImpl.class).hello();
		newMapperProxy(new TestImpl().getClass()).hello();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T newMapperProxy(Class<T> t) {
		return (T)Proxy.newProxyInstance(t.getClass().getClassLoader(), 
				t.getClass().getInterfaces(), new DynProxy(t));
	}
}
