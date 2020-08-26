package com.learn.java.lang.wangs;

public class Singleton {

    private static volatile Singleton s;

    private static Object lock;

    private Singleton(){}

    public static Singleton getInstance(){
        if(s == null){
            synchronized (lock){
                if(s == null){
                    s = new Singleton();
                }
            }
        }
        return s;
    }
}
