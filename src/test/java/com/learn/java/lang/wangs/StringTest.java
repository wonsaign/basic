package com.learn.java.lang.wangs;

public class StringTest {

	
	public static void main(String[] args) {
//		String a = null;
//		a = "test";
//		String b = "test";
//		
//		String c = new String("test");
//		
//		String ccopy = new String("testCopy");
		
//		String aa = "a" + 1;
//		String aa1 = "a1";
//		System.out.println(aa == aa1);
		
//		String s0 = "ab";
//		final String s1 = "b";
//		String s2 = "a" + s1;
		
//		StringBuffer sb = new StringBuffer("hello");
		int n = 2;
		Integer nn = 2;
//		System.out.println(nn.equals(n));
//		System.out.println(nn==n);
//		paramTest(sb, n);
//		paramTest(sb);
//		System.out.println(sb+""+n);
	}
	
	private static void paramTest(StringBuffer sb, int n) {
		sb.append("world");
		n = 4;
	}
	private static void paramTest(StringBuffer sb) {
		sb.append("world");
		int n = 4;
	}
}
