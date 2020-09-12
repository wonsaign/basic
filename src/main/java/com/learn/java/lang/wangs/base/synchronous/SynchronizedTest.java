package com.learn.java.lang.wangs.base.synchronous;

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

        tt.t2();
    }


}
