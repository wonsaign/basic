package com.learn.java.lang.wangs.pattern.prototype;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype p = new Prototype();
		
		Prototype pp = p.clone();
		
	}
}
