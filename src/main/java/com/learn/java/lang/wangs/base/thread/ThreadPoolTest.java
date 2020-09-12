package com.learn.java.lang.wangs.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors. newFixedThreadPool(20);

        executorService.execute(null);
    }
}
