package com.learn.java.lang.wangs.base.current;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class CurrentTest {

	
	private static Map<Integer,Integer> nums = new ConcurrentHashMap<>();
//	private static Map<Integer,Integer> nums = new HashMap<>();
	
	static void T() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					nums.put(i,i);
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println(nums.remove(new Random().nextInt(50)));
			}
		}).start();
		System.out.println(nums.size());
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			T();
			System.out.println(nums);
			System.out.println("-----------------");
		}
	}
}
