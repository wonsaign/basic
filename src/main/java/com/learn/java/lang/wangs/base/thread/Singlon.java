package com.learn.java.lang.wangs.base.thread;

public class Singlon {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            S s1 = S.getInstance();
            synchronized (s1){
                s1.setA(10);
            }
        });

        t.start();

        Thread t2 = new Thread(()->{
            S s2 = S.getInstance();
            synchronized (s2){
                s2.setA(20);
            }
        });
        t2.start();
    }


}
