package com.learn.java.lang.wangs.pattern.observable.主播们;

import com.learn.java.lang.wangs.pattern.observable.inter.主播;
import com.learn.java.lang.wangs.pattern.observable.主播们.女性.女主播特有的;

public class 光屁屁主播朴妮唛 extends 女主播特有的 implements 主播 {
	
	private String time;
	private String msg;
	
	public 光屁屁主播朴妮唛(String time) {
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void show(String message) {
		this.msg = message;
		showNormal();
	}
	
	private void showNormal() {
		System.out.println("欢迎"+""+"午夜"+time+"--"+"主播朴妮唛已经下播,请充值SSSVIP查看主播热舞直播");
	}
	public void showTuoguangguang() {
		System.out.println("欢迎"+""+"午夜"+time+"--"+"主播朴妮唛还有一件衣服了");
	}
	@Override
	protected void tuoguangguang() {
		showTuoguangguang();
	}
	@Override
	public boolean getSpecial() {
		return super.special;
	}
}
