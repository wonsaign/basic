package com.learn.java.lang.wangs.util;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] num= {1,0,-1,10,9,-3,7};
//		sort(num,1,7);
		qSort(num,0,6);
		
//		System.out.println(recursionMultip(5));
//		System.out.println(recursionPuls(num,0));
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

	
    static void insertionSort(int[] num ,int begin ,int end) {
    	for(int i = begin ,j = i;i < end; j= ++i){
    		int t = num[i+1];
    		while(t < num[j]) {
    			num[j+1]=num[j];
    			if(j-- == begin) { 
    				break;   
    			}
    		}
    		num[j + 1] = t;
    	}
    }
    
    static int recursionMultip(int i) {
    	//int sum = 0;
    	if(i>0) {
    		return i*recursionMultip(i-1);
    	}else {
    		return 1;
    	}
    }
    static int recursionPuls(int[] i,int move) {
    	int sulotion = i.length - move;
    	if(sulotion > 0) {
    		move++;
    		return i[sulotion-1]+recursionPuls(i , move);
    	}else {
    		return 0;
    	}
    }
    // {1,0,-1,10,9,-3,7};
    // -3 0 -1 1 9 10 7
    // -3 0 -1 1 7 9 10
    // -3 -1 0 1 7 9 10
    static void qSort(int[] a,int begin,int end) {
    	if(begin>end) {
    		return;
    	}
    	int i , j , index;
    	// 分组左部分和 右部分 , 递归
    	i = begin;
    	j = end;
    	index = a[i];
    	while(i < j) {
    		while(i < j && a[j] >= index) {
    			j--;
    		}
    		if(i<j) {
    			a[i] = a[j];
    			a[j] = index;
    			i++;
    		}
    		while(i < j && a[i] <= index){
    			i++;
    		}
    		if(i<j) {
    			a[j] = a[i];
    			a[i] = index;
    			j--;
    		}
    	}
    	qSort(a,begin,i-1);
    	qSort(a,i+1,end);
    	
    }
    
	static void sort2(int[] nums) {
		// 0  指针
		int ZeroPoint = nums.length;
		for (int i = nums.length -1 ; i >= 0; i--) {
			if(nums[i] == 0) {
				int zero = nums[i];
				int nonZeroPoint = i ;
				while(nonZeroPoint < ZeroPoint - 1) {
					nums[nonZeroPoint] = nums[nonZeroPoint+1];
					nonZeroPoint++;
				}
				nums[ZeroPoint - 1] = zero;
				ZeroPoint--;
			}
		}
	}
	
	static void contaninsChar(String a,String b) {
		a.toCharArray();
	}
}
