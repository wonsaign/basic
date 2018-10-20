package com.learn.java.lang.wangs;

public class ObjectTest extends A{

	public static void main(String[] args) {
//		// java运算符 与（&）、非（~）、或（|）、异或（^）
//		
//		// ^(亦或运算) ，针对二进制，相同的为0，不同的为1
//		System.out.println(2^3);
//		// &（与运算） 针对二进制，只要有一个为0，就为0
//		System.out.println(2&3);
//		// <<(向左位移) 针对二进制，转换成二进制后向左移动3位，后面用0补齐
//		System.out.println(2<<3);
//		// >>(向右位移) 针对二进制，转换成二进制后向右移动3位，
//		System.out.println(2>>3);
//		// >>>(无符号右移)  无符号右移，忽略符号位，空位都以0补齐
//		System.out.println(2>>>3);
		
		System.out.println(new ObjectTest().getClass().getName());
	}
}
class A{}
