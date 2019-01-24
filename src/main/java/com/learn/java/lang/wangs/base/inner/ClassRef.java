package com.learn.java.lang.wangs.base.inner;

import java.util.Map;

public class ClassRef {

	private int age;
	private String name;
	
	Map<String,String> m;
	public ClassRef() {
		super();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("unused")
	private static class StaticInnerClass{
		final int age;
		final String name;
		public StaticInnerClass(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
	}
	
	@SuppressWarnings("unused")
	class StaticNonInnerClass{
		private void syse() {
			System.err.println("我叫"+name+"我的年龄是");
		}
	}
	
	
}
