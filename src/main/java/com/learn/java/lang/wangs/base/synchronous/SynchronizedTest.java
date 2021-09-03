package com.learn.java.lang.wangs.base.synchronous;

import java.util.concurrent.locks.LockSupport;

public class SynchronizedTest {


    public synchronized void t1(){
        System.out.println("t1");
    }

    public synchronized void t2(){
        t1();
        System.out.println("t2");
    }


    public static void main(String[] args) {
        SynchronizedTest tt = new SynchronizedTest();
        SynchronizedTest tt1 = new SynchronizedTest();
        SynchronizedTest tt2 = new SynchronizedTest();
        System.out.println(tt);
        System.out.println(tt1);
        System.out.println(tt2);
        LockSupport.park(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());
        tt.t2();
    }


}
