package com.learn.java.lang.wangs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExceptionTest {

//	static void m() {
//		new Exception();
//	}
	// 区别在于 垃圾回收
	// 此方法,每次声明的对象引用在
	static void m2() {
		Object o ;// object 在整个循环都是可见的,每次循环都都替换上次的引用
		// 对于不存在引用的对象gc就可以清理了
		for (int i = 0; i < 1000; i++) {
			o = new Object();
		}
	}
	static void m3() {
		for (int i = 0; i < 1000; i++) {
			Object o = new Object();// object 在整个作用域(生命周期)都是存在,
			// 产生了1000个对象的,gc的时候要清理1000个
		}
	}
	
	public void m5() {
		List<? extends Number> l = new ArrayList<>();
		
		List<? super Number> ll = new ArrayList<>();
	}
	
	public void m4() {
		for (int i = 0; i < 1000; i++) {
			Object o = new Object();
		}
		Map m = new HashMap();
		StringBuffer sb = new StringBuffer("hi");
		String st = "im st";
		// 作用域,如果什么都不返回,匿名方法,但是作用于不可用于{}外
		{
			st = "changed";
			sb.append("world");
		}
		System.out.println(sb.toString());
		System.err.println(st);
		return;
	}
	
	public static void main(String[] args) {
		//m2();
		//m3();
		new ExceptionTest().m4();
	}
}
