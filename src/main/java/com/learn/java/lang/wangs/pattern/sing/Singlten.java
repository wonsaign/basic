package com.learn.java.lang.wangs.pattern.sing;

public class Singlten {

	private static Singlten s = new Singlten();
	
	private Singlten() {
		
	}
	public static Singlten getInstace() {
		return s;
	}
}
class Singlten2 {
	private static Singlten2 s2;
	private Singlten2() {}
	public static Singlten2 getInstace() {
		if(s2 == null) {
			synchronized(s2) {
				if(s2 == null) { // 线程
					s2 = new Singlten2();
				}
			}
		}
		return s2;
	}
}
class Singlten3{
	public static Singlten3 getInstace() {
		return Instance.instance;
	}
	private static class Instance{
		public static final Singlten3 instance = new Singlten3();
	}
}
