package com.learn.java.lang.wangs.base.current;

public class TLocal {

	private ThreadLocal<String> t ;
	public ThreadLocal<String> getT() {
		return t;
	}
	public void setT(ThreadLocal<String> t) {
		this.t = t;
	}
	public static void main(String[] args) {
		ThreadLocal<String> tl = new ThreadLocal<>();
		tl.set("123");
	}
}
