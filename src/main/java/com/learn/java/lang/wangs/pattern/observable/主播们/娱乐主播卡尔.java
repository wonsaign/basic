package com.learn.java.lang.wangs.pattern.observable.主播们;

import com.learn.java.lang.wangs.pattern.observable.inter.主播;

public class 娱乐主播卡尔  implements 主播{
	
	private String name;
	private String msg;
	
	public 娱乐主播卡尔(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		read();
	}
	
	private void read() {
		System.out.println(msg+"---------"+name);
	}

	@Override
	public boolean getSpecial() {
		// TODO Auto-generated method stub
		return false;
	}
}
