package com.learn.java.lang.wangs.base.current;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;

public class PoolAndLock {

    private ReentrantLock lock = new ReentrantLock();

    private ExecutorService pool = Executors.newFixedThreadPool(20);

    private Map<String, String> map = new HashMap<>();

    private Map<String, Object> lockMap = new HashMap<>();

    private Object lockObject = new Object();

    private String[] keys = {"wangsai", "wangsai1", "wangsai2", "wangsai1", "wangsai"};

    public static void main(String[] args) {
        PoolAndLock pal = new PoolAndLock();
        //pal.internTest(pal);

        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 5; i++) {
                final Integer ii = new Integer(i);
                pal.pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        pal.synchTest(pal, ii);
                        //pal.reentranLock(pal);
                    }
                });
            }
        }).whenComplete((t, u) -> {
            pal.pool.shutdown();
        });
        System.out.println(JSON.toJSONString(pal.map));
    }

    private void internTest(PoolAndLock pal) {
        String s1 = pal.keys[0];
        String s2 = pal.keys[4];

        String s3 = "111";
        String s4 = "111";
        System.out.println(s3 == s4);

        System.err.println(pal.keys[0] == pal.keys[4]);
        System.err.println(pal.keys[0].intern() == pal.keys[4].intern());
        System.err.println(s1 == s2);
        System.err.println(s1.intern() == s2.intern());
    }


    private void reentranLock(PoolAndLock pal) {

        String sync = "wang" + "sai";
        AtomicI ai = null;
        pal.lock.lock();
        String jsonObj = pal.map.get(sync);
        if (Strings.isNullOrEmpty(jsonObj)) {
            ai = new AtomicI();
            ai.setNum(new AtomicInteger(0));
            ai.setSync("wangsai");
        } else {
            ai = JSONObject.parseObject(jsonObj, AtomicI.class);
        }
        // +1
        ai.getNum().incrementAndGet();
        String value = JSON.toJSONString(ai);
        pal.map.put(sync, value);
        System.err.println(JSON.toJSONString(pal.map));
        lock.unlock();
    }

    /**
     * 问题原因是,两个锁,锁住的范围不一样
     *
     * @param pal
     */
    private void synchTest(PoolAndLock pal, int i) {

        String sync = pal.keys[i].intern();

        Object lock = pal.lockMap.get(sync);
        if (lock == null) {
            lock = new Object();
        }
        AtomicI ai = null;
        int limit = 10;
        synchronized (lockObject) {
            // 使用map 针对字段锁
            pal.lockMap.put(sync, lock);
            // 因为多个线程是并行走的,所以最开始获取的数据都是一样的
            String jsonObj = pal.map.get(sync);
            if (Strings.isNullOrEmpty(jsonObj)) {
                ai = new AtomicI();
                ai.setNum(new AtomicInteger(0));
                ai.setSync("vvvv");
            } else {
                ai = JSONObject.parseObject(jsonObj, AtomicI.class);
            }
            //}// 这里一旦释放锁,其他线程便会获取锁,然后下面的代码当前线程不一定走完(map赋值),所以其他线程从map获取的值很大可能卡还是null

            // +1
            int l = ai.getNum().incrementAndGet();
            if (limit >= l) {
                String value = JSON.toJSONString(ai);
                pal.map.put(sync, value);
                System.err.println(JSON.toJSONString(pal.map));
                pal.lockMap.remove(sync);
                return;
            } else {
                pal.lockMap.remove(sync);
            }
        }
    }

}


class AtomicI {
    private String sync;
    private AtomicInteger num;

    public AtomicInteger getNum() {
        return num;
    }

    public void setNum(AtomicInteger num) {
        this.num = num;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }
}