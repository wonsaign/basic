package com.learn.java.lang.wangs.base.string;

public class StringTest {

//	public static void main(String[] args) {
//		// Bearer 4df29fbd-b752-4f72-864c-d909ff311400
////		String s = "Bearer 4df29fbd-b752-4f72-864c-d909ff311400";
////		
////		System.out.println(s.substring(7));
//		String s = "E";
//		if (s.equals("A")) {
//			System.out.println("A");
//		} else if(s.equals("B")){
//			System.out.println("B");
//		} else if(s.equals("C")){
//			System.out.println("C");
//		} else {
//			System.out.println("D");
//		}
//        Map<String,String> params = new HashMap<>();
//        params.put("code", "123456");
//        params.put("name","wangs");
//        params.put("sex","man");
//        StringBuffer pramaToStr = new StringBuffer();
//        int size = params.size();
//        for (Entry<String, String> param : params.entrySet()) {
//        	if(size <= 1){
//        		pramaToStr.append(param.getKey()).append("\":\"").append(param.getValue());
//        	}else{
//        		pramaToStr.append(param.getKey()).append("\":\"").append(param.getValue()).append("\",\"");
//        	}
//        	size--;
//        }
//        StringBuffer sb = new StringBuffer();
//        sb.append("{\"").append(pramaToStr.toString()).append("\"}");
//        // {"code":"123456"}
//        System.out.println(sb.toString());
//	}
	
	static void appendStr(StringBuffer sb) {
		StringBuffer sc = new StringBuffer();
		sc = sb;
		sc.append("world");
	}
	
	public static void main(String[] args) {
//		StringBuffer sb = new StringBuffer("hello");
//		appendStr(sb);
//		System.out.println(sb.toString());
		
		String a = "1";
		
		String b = "12";
		
		System.err.println(a.indexOf(b));
	}
	
}
