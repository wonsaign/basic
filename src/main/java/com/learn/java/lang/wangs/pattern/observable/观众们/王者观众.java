package com.learn.java.lang.wangs.pattern.observable.观众们;

import java.util.ArrayList;
import java.util.List;

import com.learn.java.lang.wangs.pattern.observable.inter.主播;
import com.learn.java.lang.wangs.pattern.observable.inter.观众;

public class 王者观众 implements 观众  {

	private String level = 观众.VIP观众;
	private List<主播> list;
	private String msg;
	
	public 王者观众() {
		list = new ArrayList<>();
	}
	
	@Override
	public void registerObs(主播 o) {
		// TODO Auto-generated method stub
		list.add(o);
	}

	@Override
	public void removeObs(主播 o) {
		// TODO Auto-generated method stub
		if(!list.isEmpty())
			list.remove(o);
	}

	@Override
	public void notifyObs() {
		// TODO Auto-generated method stub
		for (主播 监视对象 : list) {
			监视对象.show(msg);
		}
	}
	
	public void setInfo(String s) {
		this.msg = s;
		notifyObs();
	}
	
}
