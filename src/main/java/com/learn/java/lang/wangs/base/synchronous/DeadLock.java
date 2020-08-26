package com.learn.java.lang.wangs.base.synchronous;

public class DeadLock {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(()->{
            synchronized (lock1){
                System.out.println("T1 get lock1");
                try {
                    Thread.sleep(1000);
                    synchronized (lock2){
                        System.out.println("T1 get lock2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            synchronized (lock2){
                System.out.println("T2 get lock1");
                synchronized (lock1){
                    System.out.println("T2 get lock2");
                }
            }
        });
        t2.start();
    }
}
