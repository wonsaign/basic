package com.learn.java.lang.wangs.pattern.observable.观众们;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.learn.java.lang.wangs.pattern.observable.inter.主播;
import com.learn.java.lang.wangs.pattern.observable.inter.观众;

public class SSSVip观众 implements 观众  {

	private String level = 观众.超级VIP观众;
	private List<主播> list;
	private String msg;
	
	public SSSVip观众() {
		list = new ArrayList<>();
	}
	
	@Override
	public void registerObs(主播 o) {
		// 您是大爷 啥都可以看
		list.add(o);
	}

	@Override
	public void removeObs(主播 o) {
		// 您是大爷 高兴就好
		if(!list.isEmpty())
			list.remove(o);
	}

	@Override
	public void notifyObs(){
		// // 您是大爷 通知全部主播
		for (主播 主播 : list) {
			if(level.equals("SSSVIP") && 主播.getSpecial()) {
				// 反射
				try {
					Method m = 主播.getClass().getDeclaredMethod("showTuoguangguang");
					try {
						m.invoke(主播);
					} catch (IllegalAccessException e) {
					} catch (IllegalArgumentException e) {
					} catch (InvocationTargetException e) {
					}
				} catch (NoSuchMethodException e1) {
				} catch (SecurityException e1) {
				}
			}else {
				主播.show(msg);
			}
		}
	}
	
	public void setInfo(String s) {
		this.msg = s;
		notifyObs();
	}
	
}
