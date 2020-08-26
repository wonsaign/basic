package com.learn.java.lang.wangs.base.exception;

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("i will thrao");
        throw new RuntimeException("异常");
    }

}

public class ThreadException {

    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler hander = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e.getMessage() + "~~~~" + t.getName());
            }

        };
        MyThread t = new MyThread();
        t.setUncaughtExceptionHandler(hander);
        //t.run();// 会报错,run是线程要执行的内容,t.run,调用的是类方法,跟线程没有毛线关系
        t.start();// start 不会报错
    }
}
