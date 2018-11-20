package com.learn.java.lang.wangs.obj;

public class Oeq {

	
	@Override
	public int hashCode() {
		return 1;
	}
	public static void main(String[] args) {
		Oeq q1 = new Oeq();
		Oeq q2 = new Oeq();
		
		System.out.println(q1 == q2);
		System.out.println(q1.equals(q2));
	}
}
