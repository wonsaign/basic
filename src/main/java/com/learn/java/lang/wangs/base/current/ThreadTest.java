package com.learn.java.lang.wangs.base.current;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
//		ExecutorService pool =  Executors.newFixedThreadPool(5);
//		Thread t1 = new MyThread();  
//		Thread tt1 = new Thread(new MyThread());
//        Thread t2 = new MyThread();  
//        Thread t3 = new MyThread();  
//        Thread t4 = new MyThread();  
//        Thread t5 = new MyThread(); 
//        
//        pool.execute(t1);  
//        pool.execute(t2);  
//        pool.execute(t3);  
//        pool.execute(t4);  
//        pool.execute(t5);  
//        // 关闭线程池  
//        pool.shutdown(); 


//		ExecutorService pool = Executors.newSingleThreadExecutor();
//		Future<String> f = pool.submit(new Call());
//
//		System.out.println(f.get(5,TimeUnit.SECONDS).toString());
//		if(f.isDone()) {
//			System.err.println("done");
//		}
//		pool.shutdown();
//		
//		for (int i = 0; i < 10; i++) {
//			Thread t = new Thread(new SimpleDaemons());
//			t.setDaemon(true);
//			t.start();
//		}
        // 上面代码可修改为
//		ExecutorService pool = Executors.newCachedThreadPool(new DaemonThreadFactory());
//		for (int i = 0; i < 10; i++) {
//			pool.execute(new SimpleDaemons());
//		}
//		System.out.println("all daemon start");
//		TimeUnit.MILLISECONDS.sleep(175);

        //	ExecutorService pool =	Executors.newCachedThreadPool();
        //	pool.submit(new RunEx());

        try {
            @SuppressWarnings("unused")
            int i = 1 / 0;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    static void Un() {
        @SuppressWarnings("unused")
        Thread.UncaughtExceptionHandler hander = new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e);
            }
        };
    }

    Thread t = new RunEx();


}

class MyThread extends Thread implements Runnable {
    @Override
    public void run() {
        System.out.println("...");
    }
}

class Call implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "hello  im callable";
    }
}

class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.err.println(Thread.currentThread() + ":" + this);
            }
        } catch (InterruptedException e) {

        }
    }
}

class RunEx extends Thread {
    //implements Callable<Object>,Runnable{
//	@Override
//	public Object call() throws Exception {
//		throw new RuntimeException("我故意出错的");
//	}
//
//	@Override
//	public void run() {
//		throw new RuntimeException("我故意出错的");
//	}
    public void run() {
        throw new RuntimeException("我故意出错的");
    }
}