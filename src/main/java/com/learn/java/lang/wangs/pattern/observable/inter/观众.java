package com.learn.java.lang.wangs.pattern.observable.inter;

// Observer
public interface 观众 {
	public static final String 普通观众 = "ordinary";
	public static final String VIP观众 = "VIP";
	public static final String 超级VIP观众 = "SSSVIP";
	
	void registerObs(主播 某主播);// 关注
	void removeObs(主播 某主播);// 取消关注
	void notifyObs();//通知观众
	
}
