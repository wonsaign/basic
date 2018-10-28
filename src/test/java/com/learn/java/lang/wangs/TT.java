package com.learn.java.lang.wangs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class TT {

//	public static void main(String[] args) {
//		Thread t = new Thread() {
//			@Override
//			public void run() {
//				System.out.println("hahaha");
//				super.run();
//			}
//		};
//		t.start();// this is the way to start the thread
//		System.out.println(t.getName());
//		t.run();// this is not the way to start the thread
//	}
	
	public static void main(String[] args) {
		PrintDoubleThread pdt = new PrintDoubleThread(2000, makeFiles());
		pdt.startUp();
	}
	
	static List<Integer> makeFiles() {
		List<Integer> dbs = new ArrayList<>(2000);
		Random m = new Random();
		for (int i = 0; i < 2000; i++) {
			dbs.add(Math.abs(m.nextInt()*2000));
		}
		return dbs;
	}
	
}
class PrintDoubleThread{
	private int size;
	List<Integer> segment;
	
	private Object lock = new Object();
	private Thread oddThread; // 单数线程
	private Thread evenThread;// 双数线程
	private final String O_T= "o";
	private final String E_T= "e";
	
	Map<String,Integer> point;
	
	public PrintDoubleThread(int size, List<Integer> segment){
		this.segment = segment;
		point = new ConcurrentHashMap<>();
		this.size = size;
		//lock.
	}
	
	private void addPoint(String type, int location) {
		synchronized (this) {
			point.put(type, location);
		}
	}
	private int getPoint(String type) {
		synchronized (this) {
			Integer location = point.get(type);
			int total = (point.get(O_T) == null ? 0 : point.get(O_T)) + (point.get(E_T) == null ? 0 : point.get(E_T));
			if(total % 500 == 0) {
				System.out.println("已经完成了:"+total);
			}
			return location == null ? 0 : location;
		}
	}
	
	public void startUp() {
		Runnable odd = new Runnable() {
			// 需要记录指针,当前线程打印的位置
			@Override
			public void run() {
				synchronized(lock) {
					int location = getPoint(O_T);
					if(location >= size) {// 执行完毕
						return;
					}
//				if(location == 0) {
//					try {
//						evenThread.wait();
//					} catch (InterruptedException e) {
//					}
//				}
					int count = 10;// 统计次数
					for (int i = location; i < size; i++) {
						if(count < 0) {
							location = i;
							break;
						}
						if(segment.get(location) % 2 == 1) {
							count--;
						}
					}
					addPoint(O_T, location);
					// 通知另外一个线程执行你的操作
					try {
						oddThread.wait();
						evenThread.notify();
					} catch (InterruptedException e) {
					}
				}
				}
		};
		Runnable even = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(lock) {
					int location = getPoint(E_T);
					if(location >= size) {// 执行完毕
						return;
					}
					int count = 10;// 统计次数
					for (int i = location; i < size; i++) {
						if(count < 0) {
							location = i;
							break;
						}
						if(segment.get(location) % 2 == 0) {
							count--;
						}
					}
					addPoint(E_T, location);
					// 通知另外一个线程执行你的操作
					try {
						evenThread.wait();
						oddThread.notify();
					} catch (InterruptedException e) {
					}
				}
				}
		};
		oddThread = new Thread(odd);
		evenThread = new Thread(even);
		oddThread.start();
		evenThread.start();
	}
	
}
