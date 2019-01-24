package com.learn.java.lang.wangs.base.math;

import java.math.MathContext;
import java.text.DecimalFormat;

public class BigDecimal {

	public static void main(String[] args) {
		double i = 1.03372631248;
		
		String s = new java.math.BigDecimal(i, new MathContext(3)).toString();
		
		System.out.println(s);
		
		DecimalFormat format = new DecimalFormat("#.00");
		String yearString = format.format(i);
		@SuppressWarnings("unused")
        Double temp= Double.valueOf(yearString);
        
        System.out.println(Double.valueOf(new DecimalFormat("#.000").format(i)));
		System.out.print("obj");
	}
}
