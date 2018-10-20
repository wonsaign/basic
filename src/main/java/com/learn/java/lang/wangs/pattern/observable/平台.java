package com.learn.java.lang.wangs.pattern.observable;

import com.learn.java.lang.wangs.pattern.observable.inter.主播;
import com.learn.java.lang.wangs.pattern.observable.inter.观众;
import com.learn.java.lang.wangs.pattern.observable.主播们.光屁屁主播朴妮唛;
import com.learn.java.lang.wangs.pattern.observable.主播们.大神主播李Faker;
import com.learn.java.lang.wangs.pattern.observable.观众们.SSSVip观众;
import com.learn.java.lang.wangs.pattern.observable.观众们.青铜观众;

/**
 *  	变态代表   	观察者
 *  	美女代表  	被观察者
 * @author wangs
 *
 */
public class 平台 {

	public static void main(String[] args) {
//		青铜观众 王二麻子 = new 青铜观众();
//		
//		主播 苗条美女 = new 大神主播李Faker("杨幂");
//		主播 丰满美女 = new 大神主播李Faker("波多老师");
//		主播 可爱美女 = new 大神主播李Faker("奶茶妹妹");
//		王二麻子.registerObs(苗条美女);
//		王二麻子.registerObs(丰满美女);
//		王二麻子.registerObs(可爱美女);
//		
//		王二麻子.setInfo("我要上你们");
//		System.out.println("-----------但是,你只有一个小兄弟---------");
//		王二麻子.removeObs(苗条美女);
//		王二麻子.removeObs(可爱美女);
//		王二麻子.setInfo("就是你了");
		
		SSSVip观众 王思聪 = new SSSVip观众();
		主播 女主播 = new 光屁屁主播朴妮唛("王思聪");
		王思聪.registerObs(女主播);
		王思聪.setInfo("");
		
		青铜观众 屌丝 = new 青铜观众();
		主播 男主播 = new 大神主播李Faker("屌丝");
		屌丝.registerObs(男主播);
		屌丝.setInfo("主播真垃圾");

	}
}
