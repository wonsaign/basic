package com.learn.java.lang.wangs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TT2 {
	private volatile static Object lock = new Object();// 共享锁对象
	
	Lock lockLock = new ReentrantLock();
	Condition conOdd = lockLock.newCondition();
	Condition conEven = lockLock.newCondition();
	
	public static void main(String[] args) {
		TT2 tt2 = new TT2();
		MyOddThread odd = tt2.new MyOddThread();
		MyEvenThread even = tt2.new MyEvenThread();
		odd.start();
		even.start();
//		if(!odd.isInterrupted()) {
//			odd.interrupt();
//			System.out.println("odd线程在wait,可以被打断");
//		}
//		if(!even.isInterrupted()) {
//			odd.interrupt();
//			System.out.println("even线程在wait,可以被打断");
//		}
	}
	class MyOddThread extends Thread {
		@Override
		public void run() {
			methodOjbect();
			System.out.println("finashed ODD");
		}
		void methodOjbect() {
			synchronized(lock) {
				try {
					System.out.println("1");
					System.out.println("3");
					System.out.println("5");
					lock.notify();
					lock.wait();// wait 不会继续往下执行,直到另外一个线程完成或者是再次wait
					System.out.println("11");
					System.out.println("33");
					System.out.println("55");
				} catch (InterruptedException e) {
				} finally {
					// 如果没有notify的话,只能通过interrupt来进行唤醒
					lock.notify();// 解锁另外一个
				}
			}
		}
		void methodCondition() {
			lockLock.lock();
			try {
				System.out.println("1");
				System.out.println("3");
				System.out.println("5");
				conEven.signal();
				conOdd.await();
				System.out.println("11");
				System.out.println("33");
				System.out.println("55");
			} catch (InterruptedException e) {
			}finally {
				conEven.signal();
				lockLock.unlock();
			}
		}
	}
	class MyEvenThread extends Thread {
		@Override
		public  void run() {
			methodOjbect();
			System.out.println("finashed EVEN");
		}
		
		void methodOjbect() {
			synchronized(lock) {
				try {
					System.out.println("2");
					System.out.println("4");
					System.out.println("6");
					lock.notify();// notify会继续执行,直到当前锁再次wait
					// this words will go to excute
					// System.out.println("notify 之后 我又进行操作了么?");
					// the lock locked again
					lock.wait();
					System.out.println("22");
					System.out.println("44");
					System.out.println("66");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// 如果没有notify的话,只能通过interrupt来进行唤醒
					lock.notify();// 解锁另外一个
				}
			}
		}
		void methodCondition(Lock lock) {
			lockLock.lock();
			try {
				System.out.println("2");
				System.out.println("4");
				System.out.println("6");
				conOdd.signal();
				conEven.await();
				System.out.println("22");
				System.out.println("44");
				System.out.println("66");
			} catch (InterruptedException e) {
			}finally {
				conOdd.signal();
				lockLock.unlock();
			}
		}
	}
}
