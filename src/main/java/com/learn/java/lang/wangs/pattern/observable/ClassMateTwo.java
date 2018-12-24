package com.learn.java.lang.wangs.pattern.observable;

public class ClassMateTwo implements Observer{

	public ClassMateTwo(Subject s) {
		s.registObs(this);
	}
	
	@Override
	public void update() {
		System.out.println("二年级的学习报更新了");
	}

}
