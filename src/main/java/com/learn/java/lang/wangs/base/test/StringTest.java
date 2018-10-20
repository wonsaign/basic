package com.learn.java.lang.wangs.base.test;

public class StringTest {

//	@Stable
//	private final byte[] value;
	
//	public StringTest(String s) {
//		this.value = s;
//	}
	
	public static void main(String[] args) {
		String a = "test";
		String b = "te" + new String("st");
		String c = new String();
		String abc = "testabc";
		byte x = 't';
		
		// hashCode 算法
		System.out.println(32*97);
		System.out.println("ab".hashCode());
		
		System.out.println(a.startsWith("t",0));
		System.out.println(x & 0xff);
		System.out.println(a.codePointBefore(1));
		System.err.println(abc.indexOf("ab"));
		
		System.out.println(a==b);
		System.out.println(a.equals(b));
		System.out.println(c);
	}
}
