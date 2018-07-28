package com.learn.java.lang.wangs.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringTest {

	public static void main(String[] args) {
		// Bearer 4df29fbd-b752-4f72-864c-d909ff311400
//		String s = "Bearer 4df29fbd-b752-4f72-864c-d909ff311400";
//		
//		System.out.println(s.substring(7));
		String s = "E";
		if (s.equals("A")) {
			System.out.println("A");
		} else if(s.equals("B")){
			System.out.println("B");
		} else if(s.equals("C")){
			System.out.println("C");
		} else {
			System.out.println("D");
		}
        Map<String,String> params = new HashMap<>();
        params.put("code", "123456");
        params.put("name","wangs");
        params.put("sex","man");
        StringBuffer pramaToStr = new StringBuffer();
        int size = params.size();
        for (Entry<String, String> param : params.entrySet()) {
        	if(size <= 1){
        		pramaToStr.append(param.getKey()).append("\":\"").append(param.getValue());
        	}else{
        		pramaToStr.append(param.getKey()).append("\":\"").append(param.getValue()).append("\",\"");
        	}
        	size--;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("{\"").append(pramaToStr.toString()).append("\"}");
        // {"code":"123456"}
        System.out.println(sb.toString());
	}
}
