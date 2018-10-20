package com.learn.java.lang.wangs.pattern.factory;

public  class HumanFactoryExtender1 extends AbsHumanFactory{

	// 共产 的实际工作，造人
	@SuppressWarnings("unchecked")
	@Override
	public  <T extends Human> T createHuman(Class<T> clazz) {
		Human human = null;
		try {
			human = (T)Class.forName(clazz.getName()).newInstance();
		}catch (Exception e) {
		}
		return (T) human;
	}
	
}
