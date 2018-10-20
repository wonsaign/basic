package com.learn.java.lang.wangs.pattern.factory;

public class HumanExtender1 implements Human{

	@Override
	public void say() {
		System.out.println("我是人类继承者1");
	}

	@Override
	public void getColor() {
		System.out.println("我是黑人");
	}

}
