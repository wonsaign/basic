package com.learn.java.lang.wangs.base.thread;

import java.util.HashMap;
import java.util.Map;

public class SyncTest {

    {
        SyncTest s1 = new SyncTest();
        s1.putE(1, "1");
    }

    static {
        SyncTest.clear();
    }

    public static void main(String[] args) {
        SyncTest s1 = new SyncTest();
        Thread t = new Thread(()->{
            s1.putE(1, "1");
            //SyncTest.putE(1, "1");
        });

        t.start();

        SyncTest s2 = new SyncTest();
        Thread t2 = new Thread(()->{
            //s2.clear();
            SyncTest.clear();
        });

        t2.start();
    }


    static Map<Integer, String> m = new HashMap<>();
    private synchronized void putE(Integer k , String v){
        System.out.println("111111");
        m.put(k, v);
        System.out.println("222222");
    }
    private static synchronized void clear(){
        System.out.println("clear....");
        m.clear();
        System.out.println("cleared----------");
    }
}
