package com.learn.java.lang.wangs.test;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num= {1,0,-1,10,9,-3,7};
		sort(num,1,7);
		
		System.out.println(Arrays.toString(num));
	}
	/**
	 * sort 
	 * @param sorted
	 * @param begin
	 * @param end
	 */
	static void sort(int[] sorted, int begin, int end) {
		for (int i = begin - 1; i < end - 1; i++) {
			while (sorted[i] > sorted[i + 1]) {
				int tmp = sorted[i];
				sorted[i] = sorted[i + 1];
				sorted[i + 1] = tmp;
				if (i-- == begin - 1) {
					break;
				}
			}
		}
	}

}
