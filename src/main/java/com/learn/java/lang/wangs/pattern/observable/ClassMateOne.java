package com.learn.java.lang.wangs.pattern.observable;

public class ClassMateOne implements Observer{

	public ClassMateOne(Subject s) {
		s.registObs(this);
	}
	
	@Override
	public void update() {
		System.out.println("一年级的学习报更新了");
	}

}
