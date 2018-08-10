package com.learn.java.lang.wangs.base.test;

import java.util.Date;

import com.learn.java.lang.wangs.util.DateTimeUtil;

public class T1 {

	
	public static void main(String[] args) {
		System.out.println(DateTimeUtil.format("YYMMDD",new Date()));
		System.out.println(String.valueOf((int)((Math.random()*9+1)*1000)));
	}
}
