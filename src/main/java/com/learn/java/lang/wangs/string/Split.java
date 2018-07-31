package com.learn.java.lang.wangs.string;

public class Split {
	
	public static void main(String[] args) {
//		String s = "nihao?imfine?hha";
//		
//		String[] ss = s.split("[?]");
//		
//		for (int i = 0; i < ss.length; i++) {
//			System.out.println(ss[i]);
//		}
//		String ssss = "on123";
//		String userName = ssss.replaceFirst("on", "");
//		System.out.println(userName);
		
		int[] a = {1,2};
		int[] b = {3,4};
		int[] c = new int[a.length+b.length];
		
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		//System.out.println(System.arraycopy(a, 0, c, 0, a.length));
	}
}
