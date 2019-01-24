package com.learn.java.lang.wangs.rebuild;

public class ReplaceMehodwithMethodObject {

	
	
/*	@SuppressWarnings("unused")
	double price(		
			double a,
			double b,
			double c,
			double d,
			double e,
			double f) {
		a = 1;
		b = 2;
		c = 3;
		d = 4;
		e = 5;
		f = 6;
		// ...
		return 0;
	}*/
	double price(		
			double a,
			double b,
			double c,
			double d,
			double e,
			double f) {
		return new CountPrice(this, a, b, c, d, e, f).countPrice();
	}
	
	@SuppressWarnings("unused")
	private class CountPrice{
		final ReplaceMehodwithMethodObject replaceMehodwithMethodObject;
		double a;
		double b;
		double c;
		double d;
		double e;
		double f;
		public CountPrice(ReplaceMehodwithMethodObject replaceMehodwithMethodObject, double a, double b, double c, double d, double e, double f) {
			super();
			this.replaceMehodwithMethodObject = replaceMehodwithMethodObject;
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
			this.f = f;
		}
		// 继续拆分到很多函数
		double countPrice() {
			a = 1;
			b = 2;
			c = 3;
			d = 4;
			e = 5;
			f = 6;
			return a;
		}
		
	}
}
