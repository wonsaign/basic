package com.learn.java.lang.wangs.base.math;

import java.math.MathContext;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalTest {

	public static void main(String[] args) {
		testChu();
	}

	static void before(){
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

	public static void testChu(){
		// BigDecimal z0 = BigDecimal.valueOf(0.0d);
		// BigDecimal z1 =BigDecimal.valueOf(0.18d);
		// BigDecimal z2 =BigDecimal.valueOf(0.2d);
		// BigDecimal z3 =BigDecimal.valueOf(0.3d);
		BigDecimal z4 =BigDecimal.valueOf(0.9d);

		BigDecimal t = BigDecimal.valueOf(0.2d) ;
		BigDecimal r0 = z4.divideAndRemainder(t)[0];
		System.err.println(r0.intValue());
	}
}
