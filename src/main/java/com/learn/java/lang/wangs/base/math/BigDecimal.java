package com.learn.java.lang.wangs.base.math;

import java.math.MathContext;

public class BigDecimal {

	public static void main(String[] args) {
		double i = 1.0332;
		
		String s = new java.math.BigDecimal(i, new MathContext(3)).toString();
		
		System.out.println(s);
		
	}
}
