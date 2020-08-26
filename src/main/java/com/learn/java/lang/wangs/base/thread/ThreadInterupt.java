package com.learn.java.lang.wangs.base.thread;

public class ThreadInterupt {

    static Object o;

    public static void main(String[] args) throws InterruptedException {

        Thread.interrupted();

        Thread.currentThread().isInterrupted();

        o.wait(1000L);
    }
}
