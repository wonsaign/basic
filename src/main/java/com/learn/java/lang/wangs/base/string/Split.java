package com.learn.java.lang.wangs.base.string;

import java.util.HashMap;
import java.util.Map;

public class Split {
	
	public static void main(String[] args) {
//		String s = "nihao?imfine?hha";
//		
//		String[] ss = s.split("[?]");
//		
//		for (int i = 0; i < ss.length; i++) {
//			System.out.println(ss[i]);
//		}
//		String ssss = "on123";
//		String userName = ssss.replaceFirst("on", "");
//		System.out.println(userName);
		
//		int[] a = {1,2};
//		int[] b = {3,4};
//		int[] c = new int[a.length+b.length];
//		
//		System.arraycopy(a, 0, c, 0, a.length);
//		System.arraycopy(b, 0, c, a.length, b.length);
//		for (int i = 0; i < c.length; i++) {
//			System.out.println(c[i]);
//		}
		//System.out.println(System.arraycopy(a, 0, c, 0, a.length));
		
		String ch = "RC002";
		String newRole = ch.substring(0, ch.length() - 1)
				+ String.valueOf(Integer.valueOf(ch.substring(ch.length() - 1)) + 1);
		System.out.println(newRole);
		
		String message = "{\"NetUserCode\": \"JDABBJZNJSYXGS7436\",	\"CompanyCode\": \"DDGJJ0396550137053\",\"Desc\": \"那个地方着火了\"}";
		System.out.println(getElement(message));
	}
	/**
	 * 正则 去掉内容
	 * @param s
	 * @return
	 */
	private static Map<Integer,String> getElement(String s){
//		String patternCopy = "[\\['(','){*}'\\]]";
		String patternCopy = "[\\[\"(\":\"){*}\"\\]]";
		String[] ss = s.split(patternCopy);
		Map<Integer,String> result = new HashMap<>();
		for (int i = 0; i < ss.length; i++) {
			if(!"".equals(ss[i].replace(" ", "").replace(",\t", ""))){
				result.put(i,ss[i]);
			}
//			if(!"".equals(ss[i].replaceAll("[\b\r\n\t]*",""))){
//				result.put(i,ss[i]);
//			}
		}
		return result;
	}
	
}
