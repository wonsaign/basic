package com.learn.java.lang.wangs;

import com.learn.java.lang.wangs.base.string.StringCopy;

public class StringTest {

	int a = 1+2;
	int c = a+3;
	
//	public static void main(String[] args) {
////		String a = null;
////		a = "test";
////		String b = "test";
////		
////		String c = new String("test");
////		
////		String ccopy = new String("testCopy");
//		
////		String aa = "a" + 1;
////		String aa1 = "a1";
////		System.out.println(aa == aa1);
//		
////		String s0 = "ab";
////		final String s1 = "b";
////		String s2 = "a" + s1;
//		
////		StringBuffer sb = new StringBuffer("hello");
////		int n = 2;
////		Integer nn = 2;
////		System.out.println(nn.equals(n));
////		System.out.println(nn==n);
////		paramTest(sb, n);
////		paramTest(sb);
////		System.out.println(sb+""+n);
//		
////		StringTest st = new StringTest();
////		st.paramTest2(sb);
////		st.paramTest2(sb);
////		st.getClass();
//
////		new StringTest().change(hi);
//		hi = new StringTest().change2();// 覆盖了
////		StringBuffer sb = new StringBuffer("hello");
////		new StringTest().paramTest(sb);
//	}
	
	static String hi = "helloworld";
//	public static void main(String[] args) {
//		change(hi);
//		System.err.println(hi);
//		StringCopy sc = new StringCopy("egnahc");
//		change3(sc);
//		System.err.println(sc.toString());
////		String ssss = hi;
////		System.out.println(hi);
//	}
	@SuppressWarnings("unused")
	private void paramTest2(StringBuffer sb) {
		//sb.append("world");
	}
	@SuppressWarnings("unused")
	private void eqAnd(){
		String a = "test";
		String b = "te"+new String("st");
		System.out.println(a==b);
		System.out.println(a.equals(b));
	}
	
	public static void change(String hi) {
		// int c = s.hashCode(); // 字符串  的hashcode值是固定的,所以无法判断,如"a".hashcode 永远等于97
		// s = "change"; // 因为String是不可变,指的是"123"和"abc"指向的jvm常量区的地址不可变
		// java传参的时候,是值传递,赋值的都是参数地址值(对象引用)的一个copy,
		// 因此对该参数所指对象的属性值修改对实参可见,对引用值本身修改对实参无影响
		// 下面的changeF()和changeT()代表了两种情况
		System.out.println(StringTest.hi==hi);
		// s.substring(0, 3);// 未修改源字符串,而是新new一个
		@SuppressWarnings("unused")
		String ss = hi;
		hi = "change";
		// 指令重排了? no
		// System.out.println("ss"+ss);
		// s = new String("change");
	}
	public static void main(String[] args) {
		changeF();
		changeT();
	}
	public static void changeF() {
		String a = "abc";
		String b = a; // b相当于a的复制,也就是形参
		b = "cde";// 相当于对b参数本身所指的地址重新赋值 <==>b = new String("cde");
		System.out.println(a+"~~~"+b);
	}
	public static void changeT() {
		char[] a = {'a','b','c'};
		char[] b = a;// b相当于a的复制,也就是形参
		b[0] = 'A';// 相当于对b参数地址所指属性值进行了修改 <==> b.setA();
		System.out.println(a[0]+"~~~"+b[0]);
	}
//	public void change() {
//		String s = "change"; 
//	}
//	public String change2() {
//		 String s = "change"; 
//		 return s;
//	}
	public static void change3(StringCopy sc) {
		 sc.setStringCopy("changed");
		 System.out.println(sc.toString());
	}
	
//	private static void paramTest(StringBuffer sb, int n) {
//		sb.append("world");
//		n = 4;
//	}
	public void paramTest(StringBuffer sb) {
		sb.append("world");
	}
//	public StringBuffer paramTest(StringBuffer sb) {
//		return sb.append("world");
//	}
}
