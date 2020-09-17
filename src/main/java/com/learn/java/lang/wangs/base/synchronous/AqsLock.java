package com.learn.java.lang.wangs.base.synchronous;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 自己动手学习一下自己写lock锁.
 *
 * @author wangsai
 */
public class AqsLock {

    private static Lock lock = new ReentrantLock();

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static ReadWriteLock rwLock = new ReentrantReadWriteLock();

    private static Semaphore semaphore = new Semaphore(2);

    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    ExecutorService s = Executors.newFixedThreadPool(1);
    ExecutorService s2 = Executors.newCachedThreadPool();

    private static Locker locker = new Locker();

    public static void main(String[] args) throws InterruptedException {
        // reentrantLockTest();
        reentrantReadWriteLockTest();
        concurrentHashMap.put("key", 1);
    }


    public static void reentrantLockTest() throws InterruptedException {
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                //locker.addOne();
                locker.safeAddOne();
            }
        });
        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                //locker.reduceOne();
                locker.safeReduceOne();
            }
        });
        Thread t3 = new Thread(()-> {
            for (int i = 0; i < 10000; i++) {
                //locker.reduceOne();
                locker.safeReduceOne();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000L);
        System.out.println("----" + locker.i);
    }

    public static void reentrantReadWriteLockTest() throws InterruptedException {
        Thread t0 = new Thread(()-> {
            locker.readGetI();
        });
        Thread t1 = new Thread(()-> {
            locker.writeLockAddOneOne();
            //locker.writeLockAddOneOne();
            //locker.readLockAddOneOne();
        });
        Thread t2 = new Thread(()-> {
            locker.readGetI();
            //locker.readLockAddOneOne();
        });
        Thread t3 = new Thread(()-> {
            locker.readGetI();
            //locker.readLockAddOneOne();
        });
        Thread t4 = new Thread(()-> {
            locker.writeLockAddOneOne();
            //locker.readLockAddOneOne();
        });
        Thread t5 = new Thread(()-> {
            locker.readGetI();
            //locker.readLockAddOneOne();
        });
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        Thread.sleep(1000L);
        System.out.println("----" + locker.i);

    }


    public static void semaphoreLockTest() throws InterruptedException {
        Thread t0 = new Thread(()-> {
            locker.semaphoreAdd();
        });
        Thread t1 = new Thread(()-> {
            locker.semaphoreAdd();
        });
        Thread t2 = new Thread(()-> {
            locker.semaphoreAdd();
        });
        Thread t3 = new Thread(()-> {
            locker.semaphoreAdd();
        });
        Thread t4 = new Thread(()-> {
            locker.semaphoreAdd();
        });
        Thread t5 = new Thread(()-> {
            locker.semaphoreAdd();
        });
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        Thread.sleep(1000L);
        System.out.println("----" + locker.i);
    }

    static class Locker{
        int i;

        public void addOne(){
            this.i++;
        }

        public void reduceOne(){
            this.i--;
        }

        public void safeAddOne(){
            lock.lock();
            try {
                locker.addOne();
            } finally {
                lock.unlock();
            }
        }

        public void safeReduceOne(){
            lock.lock();
            try {
                locker.reduceOne();
            } finally {
                lock.unlock();
            }
        }

        public int readGetI(){
            ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
            readLock.lock();
            try {
                return locker.i;
            } finally {
                readLock.unlock();
            }
        }

        public void readLockAddOneOne(){
            ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
            readLock.lock();
            try {
                locker.addOne();
            } finally {
                readLock.unlock();
            }
        }

        public void writeLockAddOneOne(){
            ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
            writeLock.lock();
            try {
                locker.addOne();
            } finally {
                writeLock.unlock();
            }
        }

        public void semaphoreAdd(){
            try {
                semaphore.acquire();
                locker.addOne();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
