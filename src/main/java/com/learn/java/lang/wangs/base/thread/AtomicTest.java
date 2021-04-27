package com.learn.java.lang.wangs.base.thread;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {


    public static void main(String[] args) {

        Table<Integer, Integer, AtomicInteger> sss = HashBasedTable.create();

        AtomicInteger i = sss.get(1, 1);
        if(i == null){
           i = new AtomicInteger(1);
        }
        setV(i);

        sss.put(1, 1, i);

        System.err.println(sss.get(1, 1).get());
    }

    public static void setV(AtomicInteger i){
        i.incrementAndGet();
    }
}
