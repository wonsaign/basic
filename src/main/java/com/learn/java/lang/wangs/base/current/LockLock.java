package com.learn.java.lang.wangs.base.current;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockLock {

	private static List<Integer> num = new CopyOnWriteArrayList<>(); // 并发容器
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		
	//	countDownLatchWay();
		barrier();
	//	sycTest(); 即使容器是安全的容器，也会因为线程的抢占导致错误
	}
	
	
	/**
	 * 信号量
	 * 切面的粗度
	 * @throws InterruptedException 
	 */
	static void semap() throws InterruptedException{
		// Callable 的实现
		final Semaphore s = new Semaphore(10);// 最大允许10个信号同时通过
		s.acquire();// 接受,持有一个信号量
		s.release();// 释放信号量
	}
	
	/**
	 * 栅栏，与闭门（CountDownPatch）类似
	 * 		区别在于，栅栏必须等到全部线程达到某一个点，才会执行，类似赛跑比赛
	 * 切面的粗度
	 * @throws InterruptedException 
	 * @throws BrokenBarrierException 
	 */
	static void barrier() throws InterruptedException, BrokenBarrierException{
		final CyclicBarrier c2 = new CyclicBarrier(2){
			@Override
			public int await() throws InterruptedException, BrokenBarrierException {
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						for (int i = 0; i < num.size(); i++) {
							System.identityHashCode(num);
							num.remove(i);
						}
					}
				});
				t.start();
				System.out.println(t.getName() +  " count down is ok");
				System.err.println("删除完毕，大小"+num.size());
				return 0;
			}
		};
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
			for (int i = 0; i < 5; i++) {
				num.add(i);
			}
//			c2.reset();
			System.out.println("T1填充完毕，大小"+num.size());
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
			for (int i = 0; i < 5; i++) {
				num.add(i);
			}
//			c2.reset();
			System.out.println("T2填充完毕，大小"+num.size());
			}
		});
		c2.await();// 此CountDownLatch在此等候，只有计数小于0的时候，该线程才会执行
		// t1,t2 混合插入
		t1.start(); 
		t2.start();
//		c.countDown();// 这里调用和上面调用是一样的
	}
	
	
	/**
	 * FutureTask 是 Future的实现类
	 */
	static void futureTaskT(){
		// Callable 的实现
		final FutureTask<Integer> f = new FutureTask<>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return null;
			}
		});
		@SuppressWarnings("unused")
		Thread t = new Thread(f);
	}
	
	/**
	 * 同步工具CountDownLatch，基于计数器，当计数为0的时候，才会执行，保证了某一个线程的执行顺序
	 * @throws InterruptedException
	 */
	static void countDownLatchWay() throws InterruptedException{
		//线程计数1
		final CountDownLatch c = new CountDownLatch(10){
			@Override
			public void await() throws InterruptedException {
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						for (int i = 0; i < num.size(); i++) {
							num.remove(i);
						}
					}
				});
				t.start();
				System.out.println(t.getName() +  " count down is ok");
				System.err.println("删除完毕，大小"+num.size());
			}
		};
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
			for (int i = 0; i < 5; i++) {
				num.add(i);
			}
			c.countDown();// 执行完毕，CountDownLatch计数减1
			System.out.println("T1填充完毕，大小"+num.size());
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
			for (int i = 0; i < 5; i++) {
				num.add(i);
			}
			c.countDown();// 执行完毕，CountDownLatch计数减1
			System.out.println("T2填充完毕，大小"+num.size());
			}
		});
		c.await();// 此CountDownLatch在此等候，只有计数小于0的时候，该线程才会执行
		Thread.sleep(20);
		// t1,t2 混合插入
		t1.start(); 
		t2.start();
//		c.countDown();// 这里调用和上面调用是一样的
	}
	

	
	
	static void blocking() throws InterruptedException{
		BlockingQueue<Integer> b = new LinkedBlockingDeque<>();//FIFO
		BlockingQueue<Integer> p = new PriorityBlockingQueue<>();//FIFO
		b.put(1);
		b.put(2);
		b.put(3);
		p.put(1);
		p.put(2);
		p.put(3);
		System.err.println("size="+b.size());
		b.poll(1, TimeUnit.SECONDS);
		
//		Thread.sleep(2000);
		for (Integer i : b) {
			System.out.println(i);
		}
	}
	
	static void sycTest(){
		for (int i = 0; i < 50; i++) {
		
			new Thread(new Runnable() {
				@Override
				public synchronized void run() {
					for (int i = 0; i < 100; i++) {
						num.add(i);
					}
				}
			}).start();
			System.out.println("num size="+num.size());
			new Thread(new Runnable() {
				@Override
				public synchronized void run() {
					for (int i = 0; i < num.size(); i++) {
						num.remove(i);
					}
				}
			}).start();
			System.err.println("num size="+num.size());
		}
	}

}
class sync{
	private int i = 0;
	/**
	 * 
	 * 同步synchronized,锁住的是每个对象的头部代表标识位的0或1,每个对象的头部都有几个信息,hashcode,锁标识位
	 * 
	 */
	synchronized int sysMethod() throws InterruptedException {
		++i;
		TimeUnit.MILLISECONDS.sleep(500);
		++i;
		return i;
	}
}

class lock{
	private int i = 0;
	private final Lock lock = new ReentrantLock();
	@SuppressWarnings("unused")
	private final Condition con = lock.newCondition();
	
	int lockNum() throws InterruptedException {
		
		try {
			while(lock.tryLock(500,TimeUnit.MILLISECONDS)){
				++i;
				TimeUnit.MILLISECONDS.sleep(500);
				++i;
			}
			
		}catch (Exception e) {
			
		}finally {
				lock.unlock();
		}
		return i;
	}
}