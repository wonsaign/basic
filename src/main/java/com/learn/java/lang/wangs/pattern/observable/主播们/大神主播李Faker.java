package com.learn.java.lang.wangs.pattern.observable.主播们;

import com.learn.java.lang.wangs.pattern.observable.inter.主播;

public class 大神主播李Faker  implements 主播{
	
	private String time;// 开播时间
	private String msg; // 正在进行时...
	
	public 大神主播李Faker(String time) {
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
		read();
	}
	
	private void read() {
		System.out.println("欢迎:"+time+"进入直播间---Now:Faker被"+msg+"单杀了");
	}


	@Override
	public boolean getSpecial() {
		// TODO Auto-generated method stub
		return false;
	}
}
