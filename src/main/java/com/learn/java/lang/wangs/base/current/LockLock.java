package com.learn.java.lang.wangs.base.current;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
class sync{
	private int i = 0;
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