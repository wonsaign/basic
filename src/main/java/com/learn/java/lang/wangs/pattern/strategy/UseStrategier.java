package com.learn.java.lang.wangs.pattern.strategy;

public abstract class UseStrategier {
	
	Changeable change;
	
	void mineFly() {
		change.fly();
	}
	
	void setChanger(Changeable c) {
		this.change = c;
	}
}

interface Changeable {
	void fly();
}