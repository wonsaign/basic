package com.learn.java.lang.wangs.pattern.factory;

public abstract class AbsHumenFactory {
	public  abstract  <T extends Human>T createHuman(Class<T> clazz);
}
