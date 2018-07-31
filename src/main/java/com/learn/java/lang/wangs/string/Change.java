package com.learn.java.lang.wangs.string;

public class Change {

	
	public static void main(String[] args) {
		int i[] = {1,2,3};
	//	int j[] = new int[3];
		
		System.out.println(getSum(i));
	}
	
	static int getSum(int ...is){
		int result = 0;
		for (int i = 0; i < is.length; i++) {
			result += is[i];
		}
		return result;
	}
}
