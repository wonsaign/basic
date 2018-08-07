package com.learn.java.lang.wangs.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTime {

	
	public static void main(String[] args) {
		
//		long l = 1533096160971L;
//		d.setTime(l);
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(1533206299000L));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(1533277385000L));
		
	    Calendar cld = Calendar.getInstance();
	    System.out.println("first Week = "+cld.getFirstDayOfWeek());
	   
	   // cld.set(Calendar.DATE, 1);//将今天设为1号
	    System.out.println("时"+cld.get(Calendar.HOUR_OF_DAY));
	    System.out.println("分"+cld.get(Calendar.MINUTE));
	    System.out.println("秒"+cld.get(Calendar.SECOND));
	    System.out.println("本周"+(cld.get(Calendar.DAY_OF_WEEK)-1));
	    System.out.println("本月"+cld.get(Calendar.DAY_OF_MONTH));

	}
}
