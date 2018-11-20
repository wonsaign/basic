package com.learn.java.lang.wangs.rebuild;

import java.util.Date;

public class IntroduceLocalExtension {

	// TODO: rebuild
	private static Date nextDate(Date arg) {
		return new Date(arg.getYear(),arg.getMonth(),arg.getDate()+1);
	};
}
class MyDateSub extends Date{
	public MyDateSub(String dateString) {
		super(dateString);
	}
	public MyDateSub(Date arg) {
		super(arg.getTime());
	}
	Date nextDay() {
		return new Date(getYear(),getMonth(),getDate()+1);
	}
	
}