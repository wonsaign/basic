package com.learn.java.lang.wangs.base.current;


import com.alibaba.fastjson.JSONObject;

public class TLocal extends Thread{

	private final static ThreadLocal<String> t = new ThreadLocal<>();
	
	TLocal.TMap tmaps = null;
	public String getT() {
		return t.get();
	}
	public void setT(String value) {
		t.set(value);
	}
	public static String getTimes(int i) {
		return String.valueOf(i);
	}
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(Thread.currentThread());
	}
	
	static class TMap{
		
	}
	
	public static void main(String[] args) {
		TLocal tl = new TLocal();
		//Thread t = Thread.currentThread();
		System.out.println(tl.toString());
		
	}
}
