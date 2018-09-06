package com.learn.java.lang.wangs.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {

	
	public static void main(String[] args) {
		
//		long l = 1533096160971L;
//		d.setTime(l);
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
//		long timeCha = 8*60*60*1000;
//		System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(1534101068533L));
		System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(1535452379406L));
	    Calendar cld = Calendar.getInstance();
	    System.out.println("first Week = "+cld.getFirstDayOfWeek());
	    
//	    System.err.println(new Date(new Date().getTime() - 2*24*60*60*1000));
	   
	   // cld.set(Calendar.DATE, 1);//将今天设为1号
//	    System.out.println("时"+cld.get(Calendar.HOUR_OF_DAY));
//	    System.out.println("分"+cld.get(Calendar.MINUTE));
//	    System.out.println("秒"+cld.get(Calendar.SECOND));
//	    System.out.println("本周"+(cld.get(Calendar.DAY_OF_WEEK)-1));
//	    System.out.println("本月"+cld.get(Calendar.DAY_OF_MONTH));

	}
}
