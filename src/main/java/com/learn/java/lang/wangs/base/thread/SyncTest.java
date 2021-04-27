package com.learn.java.lang.wangs.base.thread;

import java.util.HashMap;
import java.util.Map;

public class SyncTest {

    Map<Integer, String> m = new HashMap<>();

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        Thread t = new Thread(()->{
            syncTest.putE(1, "1");
        });

        t.start();

        Thread t2 = new Thread(()->{
            syncTest.clear();
        });

        t2.start();
    }


    private synchronized void putE(Integer k , String v){
        System.out.println("111111");
        m.put(k, v);
        System.out.println("222222");
    }

    private synchronized void clear(){
        System.out.println("clear....");
        m.clear();
        System.out.println("cleared----------");
    }
}
