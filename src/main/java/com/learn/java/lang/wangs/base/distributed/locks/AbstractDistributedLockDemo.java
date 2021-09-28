//package com.learn.java.lang.wangs.base.distributed.locks;
//
//import org.apache.curator.RetryPolicy;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.recipes.cache.ChildData;
//import org.apache.curator.framework.recipes.cache.PathChildrenCache;
//import org.apache.curator.framework.recipes.locks.InterProcessLock;
//import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
//import org.apache.curator.framework.recipes.locks.InterProcessMutex;
//import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
//import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
//import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreV2;
//import org.apache.curator.framework.recipes.locks.Lease;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
///**
// * All rights Reserved, Designed By www.drplant.com.cn
// *
// * @ProjectName: dc-service-crm
// * @Package: com.zeusas.cloud.dc.crm
// * @ClassName: DistributedLockDemo
// * @Description: [zk curator 分布式锁]
// * @Author: [wang sai]
// * @Date: 2021/9/28 10:50 上午
// * @Version: V1.0
// * @Copyright: 2019 www.drplant.com.cn Inc. All rights reserved.
// **/
//public abstract class AbstractDistributedLockDemo {
//
//    // ZooKeeper 锁节点路径, 分布式锁的相关操作都是在这个节点上进行
//    protected final String lockPath = "/distributed-lock";
//
//
//    // 重试策略
//    // 初始休眠时间为 1000ms, 最大重试次数为 3
//    // Curator 客户端重试策略
//    protected RetryPolicy retry = new ExponentialBackoffRetry(1000, 3);;
//
//    // Curator 客户端对象
//    protected CuratorFramework client;
//    // client2 用户模拟其他客户端
//    protected CuratorFramework client2;
//
//
//    // 初始化资源
//    @Before
//    public void init() throws Exception {
//        start();
//        startWatcher();
//    }
//
//    public abstract void start();
//    public abstract void end();
//
//    // 释放资源
//    @After
//    public void close() {
//        end();
//    }
//
//    private void startWatcher(){
//        // 2.Register watcher
//        PathChildrenCache watcher = new PathChildrenCache(
//                client,
//                lockPath,
//                true    // if cache data
//        );
//        watcher.getListenable().addListener((client1, event) -> {
//            ChildData data = event.getData();
//            if (data == null) {
//                System.out.println("No data in event[" + event + "]");
//            } else {
//                System.out.println("Receive event: "
//                        + "type=[" + event.getType() + "]"
//                        + ", path=[" + data.getPath() + "]"
//                        + ", data=[" + new String(data.getData()) + "]"
//                        + ", stat=[" + data.getStat() + "]");
//            }
//        });
//        try {
//            watcher.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.err.println("Register zk watcher successfully!");
//    }
//
//
//    // 分布式排它锁 不可冲入
//    @Test
//    public void sharedLock() throws Exception {
//        // 创建共享锁
//        InterProcessLock lock = new InterProcessSemaphoreMutex(client, lockPath);
//        // lock2 用于模拟其他客户端
//        InterProcessLock lock2 = new InterProcessSemaphoreMutex(client2, lockPath);
//
//        // 获取锁对象
//        lock.acquire();
//
//        // 获取锁失败，已经被其他上锁
//        Assert.assertFalse(lock2.acquire(2, TimeUnit.SECONDS));
//
//        // 测试是否可以重入
//        // 超时获取锁对象(第一个参数为时间, 第二个参数为时间单位), 因为锁已经被获取, 所以返回 false
//        Assert.assertFalse(lock.acquire(2, TimeUnit.SECONDS));
//
//        // NOT passed 不可重入
//        // Assert.assertTrue(lock.acquire(2, TimeUnit.SECONDS));
//
//        // 释放锁
//        lock.release();
//
//        // lock2 尝试获取锁成功, 因为锁已经被释放
//        Assert.assertTrue(lock2.acquire(2, TimeUnit.SECONDS));
//        lock2.release();
//    }
//
//
//    // 分布式可重入排它锁
//    @Test
//    public void sharedReentrantLock() throws Exception {
//        // 创建可重入锁
//        InterProcessLock lock = new InterProcessMutex(client, lockPath);
//        // lock2 用于模拟其他客户端
//        InterProcessLock lock2 = new InterProcessMutex(client2, lockPath);
//        // lock 获取锁
//        lock.acquire();
//        try {
//            // lock 第二次获取锁
//            lock.acquire();
//            try {
//                // lock2 超时获取锁, 因为锁已经被 lock 客户端占用, 所以获取失败, 需要等 lock 释放
//                Assert.assertFalse(lock2.acquire(2, TimeUnit.SECONDS));
//            } finally {
//                lock.release();
//            }
//        } finally {
//            // 重入锁获取与释放需要一一对应, 如果获取 2 次, 释放 1 次, 那么该锁依然是被占用, 如果将下面这行代码注释, 那么会发现下面的 lock2 获取锁失败
//            lock.release();
//        }
//        // 在 lock 释放后, lock2 能够获取锁
//        Assert.assertTrue(lock2.acquire(2, TimeUnit.SECONDS));
//        lock2.release();
//    }
//
//
//
//    // 分布式读写锁
//    @Test
//    public void sharedReentrantReadWriteLock() throws Exception {
//        // 创建读写锁对象, Curator 以公平锁的方式进行实现
//        InterProcessReadWriteLock lock = new InterProcessReadWriteLock(client, lockPath);
//        // lock2 用于模拟其他客户端
//        InterProcessReadWriteLock lock2 = new InterProcessReadWriteLock(client2, lockPath);
//        // 使用 lock 模拟读操作
//        // 使用 lock2 模拟写操作
//        // 获取读锁(使用 InterProcessMutex 实现, 所以是可以重入的)
//        InterProcessLock readLock = lock.readLock();
//        // 获取写锁(使用 InterProcessMutex 实现, 所以是可以重入的)
//        InterProcessLock writeLock = lock2.writeLock();
//
//        /**
//         * 读写锁测试对象
//         */
//        class ReadWriteLockTest {
//            // 测试数据变更字段
//            private Integer testData = 0;
//            private Set<Thread> threadSet = new HashSet<>();
//
//            // 写入数据
//            private void write() throws Exception {
//                writeLock.acquire();
//                try {
//                    Thread.sleep(10);
//                    testData++;
//                    System.out.println("写入数据 \t" + testData);
//                } finally {
//                    writeLock.release();
//                }
//            }
//
//            // 读取数据
//            private void read() throws Exception {
//                readLock.acquire();
//                try {
//                    Thread.sleep(10);
//                    System.out.println("读取数据 \t" + testData);
//                } finally {
//                    readLock.release();
//                }
//            }
//
//            // 等待线程结束, 防止 test 方法调用完成后, 当前线程直接退出, 导致控制台无法输出信息
//            public void waitThread() throws InterruptedException {
//                for (Thread thread : threadSet) {
//                    thread.join();
//                }
//            }
//
//            // 创建线程方法
//            private void createThread(int type) {
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            if (type == 1) {
//                                write();
//                            } else {
//                                read();
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                threadSet.add(thread);
//                thread.start();
//            }
//
//            // 测试方法
//            public void test() {
//                for (int i = 0; i < 5; i++) {
//                    createThread(1);
//                }
//                for (int i = 0; i < 5; i++) {
//                    createThread(2);
//                }
//            }
//        }
//
//        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
//        readWriteLockTest.test();
//        readWriteLockTest.waitThread();
//    }
//
//    // 共享信号量
//    @Test
//    public void semaphore() throws Exception {
//        // 创建一个信号量, Curator 以公平锁的方式进行实现
//        InterProcessSemaphoreV2 semaphore = new InterProcessSemaphoreV2(client, lockPath, 6);
//        // semaphore2 用于模拟其他客户端
//        InterProcessSemaphoreV2 semaphore2 = new InterProcessSemaphoreV2(client2, lockPath, 6);
//
//        // 获取一个许可
//        Lease lease = semaphore.acquire();
//        Assert.assertNotNull(lease);
//        // semaphore.getParticipantNodes() 会返回当前参与信号量的节点列表, 俩个客户端所获取的信息相同
//        Assert.assertEquals(semaphore.getParticipantNodes(), semaphore2.getParticipantNodes());
//
//        // 超时获取一个许可
//        Lease lease2 = semaphore2.acquire(2, TimeUnit.SECONDS);
//        Assert.assertNotNull(lease2);
//        Assert.assertEquals(semaphore.getParticipantNodes(), semaphore2.getParticipantNodes());
//
//        // 获取多个许可, 参数为许可数量
//        Collection<Lease> leases = semaphore.acquire(2);
//        Assert.assertTrue(leases.size() == 2);
//        Assert.assertEquals(semaphore.getParticipantNodes(), semaphore2.getParticipantNodes());
//
//        // 超时获取多个许可, 第一个参数为许可数量
//        Collection<Lease> leases2 = semaphore2.acquire(2, 2, TimeUnit.SECONDS);
//        Assert.assertTrue(leases2.size() == 2);
//        Assert.assertEquals(semaphore.getParticipantNodes(), semaphore2.getParticipantNodes());
//
//        // 目前 semaphore 已经获取 3 个许可, semaphore2 也获取 3 个许可, 加起来为 6 个, 所以他们无法再进行许可获取
//        Assert.assertNull(semaphore.acquire(2, TimeUnit.SECONDS));
//        Assert.assertNull(semaphore2.acquire(2, TimeUnit.SECONDS));
//
//        // 释放一个许可
//        semaphore.returnLease(lease);
//        semaphore2.returnLease(lease2);
//        // 释放多个许可
//        semaphore.returnAll(leases);
//        semaphore2.returnAll(leases2);
//    }
//
//
//    // 多重共享锁
//    @Test
//    public void multiLock() throws Exception {
//        // 可重入锁
//        InterProcessLock interProcessLock1 = new InterProcessMutex(client, lockPath);
//        // 不可重入锁 分布式排它锁
//        InterProcessLock interProcessLock2 = new InterProcessSemaphoreMutex(client2, lockPath);
//        // 创建多重锁对象 将多个锁作为单个实体管理的容器
//        InterProcessLock lock = new InterProcessMultiLock(Arrays.asList(interProcessLock1, interProcessLock2));
//        // 获取参数集合中的所有锁
//        lock.acquire();
//
//        // 因为存在一个不可重入锁, 所以整个 InterProcessMultiLock 不可重入
//        Assert.assertFalse(lock.acquire(2, TimeUnit.SECONDS));
//        // interProcessLock1 是可重入锁, 所以可以继续获取锁
//        Assert.assertTrue(interProcessLock1.acquire(2, TimeUnit.SECONDS));
//        // interProcessLock2 是不可重入锁, 所以获取锁失败
//        Assert.assertFalse(interProcessLock2.acquire(2, TimeUnit.SECONDS));
//
//        // 释放参数集合中的所有锁
//        lock.release();
//
//        // interProcessLock2 中的锁已经释放, 所以可以获取
//        Assert.assertTrue(interProcessLock2.acquire(2, TimeUnit.SECONDS));
//
//    }
//
//
//}
