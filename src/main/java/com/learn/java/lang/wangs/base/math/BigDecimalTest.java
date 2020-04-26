package com.learn.java.lang.wangs.base.math;

import java.math.MathContext;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalTest {

	public static void main(String[] args) {
		//testChu();
		//testChu2();
		//test3();
		test4();
	}
	
	public static void test4(){
	    BigDecimal a = BigDecimal.valueOf(11);
	    BigDecimal b = BigDecimal.valueOf(11.00);
	    System.err.println(a.compareTo(b) == 0);
	}	
	public static void test3(){
	    if(null instanceof Integer) {
	        System.err.println("~~~~~");
	    }
	    
	    BigDecimal a = BigDecimal.valueOf(661);
	    BigDecimal b = BigDecimal.valueOf(36642);
	    S s = new S();
	    //s.setX((a.divide(b, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100))).toString() + "%");
	    s.setX((BigDecimal.valueOf(0.02).multiply(BigDecimal.valueOf(100))).toString() + "%");
	    System.err.println(s.getX());
	}	
	
	static class S{
	    String x;

        public String getX() {
            return x;
        }

        public void setX(String x) {
            this.x = x;
        }
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
		
		
		BigDecimal ten = new BigDecimal(2);
		BigDecimal three = new BigDecimal(3);
		
		System.out.println(ten.divide(three,2,RoundingMode.HALF_DOWN));
		
		System.err.println(r0.intValue());
	}
	
    public static void testChu2() {
        BigDecimal valueOf = BigDecimal.valueOf(1256.4d);
        int dev = 2000;
        
        BigDecimal divideToIntegralValue = valueOf.divideToIntegralValue(BigDecimal.valueOf(dev));
        BigDecimal remainder = valueOf.remainder(BigDecimal.valueOf(dev));
        
        System.out.println(divideToIntegralValue);
        System.err.println(remainder);
    }
}
