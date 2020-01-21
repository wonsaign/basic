package com.learn.java.lang.wangs.base.synchronous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplateTests {

    
    private static ExecutorService pool =  Executors.newFixedThreadPool(5);
    
    private static CompletionService<String> completionService = new ExecutorCompletionService<String>(pool);
    
    private static KeySetView<String, Boolean> threadIdSet = ConcurrentHashMap.<String>newKeySet();
    
    private static String[] studentPool = {"0","1","2","3","4","5","6","7","8","9","10","11",
            "John","Tom","Kim","Jack","Rose","MrKang","Wangs","John","Tom","Jack","Luence",
            "Sakura","Naruto","Saseiki","Kakasi","John","Tom","Rose",
            "John","Tom","Kim","Jack","Rose","MrKang","Wangs","John","Tom","Jack","Luence",
            "Sakura","Naruto","Saseiki","Kakasi","John","Tom","Rose",
            "John","Tom","Kim","Jack","Rose","MrKang","Wangs","John","Tom","Jack","Luence",
            "Sakura","Naruto","Saseiki","Kakasi","John","Tom","Rose",
            "John","Tom","Kim","Jack","Rose","MrKang","Wangs","John","Tom","Jack","Luence",
            "Sakura","Naruto","Saseiki","Kakasi","John","Tom","Rose",
            "John","Tom","Kim","Jack","Rose","MrKang","Wangs","John","Tom","Jack","Luence",
            "Sakura","Naruto","Saseiki","Kakasi","John","Tom","Rose",
            "John","Tom","Kim","Jack","Rose","MrKang","Wangs","John","Tom","Jack","Luence",
            "Sakura","Naruto","Saseiki","Kakasi","John","Tom","Rose",
            "John","Tom","Kim","Jack","Rose","MrKang","Wangs","John","Tom","Jack","Luence",
            "Sakura","Naruto","Saseiki","Kakasi","John","Tom","Rose"};
    
    private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        
        /** ----------------------------Multi Thread--------- **/
        
//        for (int i = 0; i < 1; i++) {
//            threadTest();
//        }
        
        //threadTest();
        for (int i = 0; i < 3; i++) {
            completionService.submit(new Task(i));
        }
        for (int i = 0; i < 3; i++) {
            try {
                completionService.take();
            } catch (InterruptedException e) {
            }
        }
        
        
        if(true) {
            @SuppressWarnings("unused")
            int i = 1>>2;
            @SuppressWarnings("unused")
            int ii = 2>>2;
        }
    }
    
    public static class Task implements Callable<String>{
        
        private int i;
        
        public int getI() {return i;}
        
        public Task(int i) {this.i = i;}

        @Override
        public String call() throws Exception {
            final Set<String> removes = new HashSet<>();
            
            List<Callable<String>> cs = new ArrayList<>();
            for (int i = 0; i < 200; i++) {
                Callable<String> c = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        long tid = Thread.currentThread().getId();
                        //System.err.println(tid);
                        try {
//                            if(tid % 2 == 0) {
//                                throw new RuntimeException(Thread.currentThread().getId() + "偶数报错" + tid);
//                            }   
                        } catch (Exception e) {
                            throw new RuntimeException(e.getMessage() + Thread.currentThread().getName() + "给我错最开始");
                        }
                        return studentPool[(int)tid];
                    }
                };
                cs.add(c);
            }
            
            // run 匿名Runnable 不支持返回值
            
            CompletableFuture.runAsync(() -> {
                for(int i = 0;i < 10000000;i++){
                    map.put(String.valueOf(i),"我是"+ i);
                }
                System.err.println("---------第一步线程：" + Thread.currentThread().getName());
                for (Callable<String> task : cs) {
                    completionService.submit(task);
                };
                for (@SuppressWarnings("unused") Callable<String> callable : cs) {
                    try {
                        removes.add(completionService.take().get());
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("我在哪儿");
                        throw new RuntimeException(e.getMessage() + Thread.currentThread().getName() + "给我错最开始");
                    }
                }
            }).handle((t, u)-> {
                if(map.size() == 10000000) {
                    System.err.println("---------第二步线程：" + map.size());
                }
                if(u != null) {
                    System.out.println("我是谁");
                    throw new RuntimeException(Thread.currentThread().getName() + u.getMessage()+ "再然后");
                }
                for (String temp : removes) {
                    System.err.println("清空完成的学生=" + temp + "----" +Thread.currentThread().getName());
                    // catch exception 回滚
                    if(u == null) {
                        threadIdSet.remove(temp);
                    }
                }
                System.err.println("当前线程" + Thread.currentThread().getName() + "缓存中还剩下的空间=" + threadIdSet.size());
                return null;
            }).whenCompleteAsync((t, u)->{
                if(u != null) {
                    String customerMsg = "ErrorHappen:" + u.getMessage();
                    System.out.println("我错了=" + i + "------" + customerMsg);
                    throw new RuntimeException(Thread.currentThread().getName() + customerMsg + "到最后");
                }
                System.out.println("我完成了=" + Thread.currentThread().getName());
                }
            );
            return "";
        }
        
    }
    
    static void threadTest() {
        
        final Set<String> removes = new HashSet<>();
        
        List<Callable<String>> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Callable<String> c = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    long tid = Thread.currentThread().getId();
                    System.err.println(tid);
                    try {
                        if(tid % 2 == 0) {
                            throw new RuntimeException(Thread.currentThread().getId() + "奥数报错" + tid);
                        }   
//                        // 查
//                        String stuName = studentPool[(int)tid];
//                        // 存
//                        if(!threadIdSet.add(stuName)) {
//                            // 测试逻辑
//                            throw new RuntimeException(Thread.currentThread().getName() + "当前学生" + stuName + "资源已经存在");
//                        };
                        //System.out.println("我完成了,我没报错"+ tid);
                    } catch (Exception e) {
                       // 加业务回滚
                       //System.err.println("我要回滚了，因为=>"+e.getMessage());
                        //System.out.println("我在哪儿");
                        throw new RuntimeException(e.getMessage() + Thread.currentThread().getName() + "给我错最开始");
                    }
                    return studentPool[(int)tid];
                }
            };
            cs.add(c);
        }
        
        // run 匿名Runnable 不支持返回值
        
        CompletableFuture.runAsync(() -> {
            // System.err.println("---------第一步线程：" + Thread.currentThread().getName());
            for (Callable<String> task : cs) {
                completionService.submit(task);
            };
            for (@SuppressWarnings("unused") Callable<String> callable : cs) {
                try {
                    removes.add(completionService.take().get());
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("我在哪儿");
                    throw new RuntimeException(e.getMessage() + Thread.currentThread().getName() + "给我错最开始");
                }
            }
        }).handle((t, u)-> {
          if(u != null) {
              System.out.println("我是水");
              throw new RuntimeException(Thread.currentThread().getName() + u.getMessage()+ "再然后");
          }
          for (String temp : removes) {
              System.err.println("清空完成的学生=" + temp + "----" +Thread.currentThread().getName());
              // catch exception 回滚
              if(u == null) {
                  threadIdSet.remove(temp);
              }
          }
          System.err.println("当前线程" + Thread.currentThread().getName() + "缓存中还剩下的空间=" + threadIdSet.size());
          return null;
        }).whenCompleteAsync((t, u)->{
            if(u != null) {
                String customerMsg = "ErrorHappen:" + u.getMessage();
                System.out.println("我错了=" + customerMsg);
                throw new RuntimeException(Thread.currentThread().getName() + customerMsg + "到最后");
            }
            System.out.println("我完成了=" + Thread.currentThread().getName());
            }
        );
    }

    static void before1_8() {

//        final Set<String> removes = new HashSet<>();
//        List<Callable<String>> cs = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Callable<String> c = new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    long tid = Thread.currentThread().getId();
//                    try {
//                        // 查
//                        String stuName = studentPool[(int) tid];
//                        // 存
//                        if (!threadIdSet.add(stuName)) {
//                            // 测试逻辑
//                            throw new Exception("当前学生资源已经存在");
//                        }
//                        ;
//                        // Thread.sleep(5000);
//                        // 分
//                        // System.out.println("学生资源="+ studentPool[(int)tid]);
//                        // 我认为完成了业务
//                        // 清除记录
//                        // removes.add(stuName);
//                    } catch (Exception e) {
//                        // 加业务回滚
//                        // System.err.println("我要回滚了，因为=>"+e.getMessage());
//                    }
//                    return studentPool[(int) tid];
//                }
//            };
//            cs.add(c);
//        }
//
//        CompletableFuture.runAsync(() -> {
//            // System.err.println("---------第一步线程：" + Thread.currentThread().getName());
//            for (Callable<String> task : cs) {
//                completionService.submit(task);
//            }
//            ;
//            for (@SuppressWarnings("unused")
//            Callable<String> callable : cs) {
//                try {
//                    removes.add(completionService.take().get());
//                } catch (InterruptedException | ExecutionException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).handle(new BiFunction<Void, Throwable, Void>() {
//            @Override
//            public Void apply(Void t, Throwable u) {
//                // System.out.println("---------第二步线程：" + Thread.currentThread().getName());
//                for (String temp : removes) {
//                    // System.err.println("清空完成的学生=" + temp);
//                    threadIdSet.remove(temp);
//                }
//                System.err.println("当前线程" + Thread.currentThread().getName() + "缓存中还剩下的空间=" + threadIdSet.size());
//                return null;
//            }
//        }).whenCompleteAsync(new BiConsumer<Void, Throwable>() {
//            @Override
//            public void accept(Void t, Throwable u) {
//                System.out.println("我完成了=" + Thread.currentThread().getName());
//            }
//        });
    }
    
    static void threadThinkings() {
        
//        KeySetView<String, Boolean> threadIdSet = ConcurrentHashMap.<String>newKeySet();
//        final Set<String> removes = new HashSet<>();
//        
//        List<Callable<Integer>> cs = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Callable<Integer> c = new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    try {
//                        long tid = Thread.currentThread().getId();
//                        String stuName = studentPool[(int)tid];
//                        if(!threadIdSet.add(stuName)) {
//                            // 测试逻辑
//                            throw new Exception("当前学生资源已经存在");
//                        };
//                        // Thread.sleep(10000);
//                        System.out.println("学生资源="+ studentPool[(int)tid]);
//                        // 我认为完成了业务
//                        removes.add(stuName);
//                    } catch (Exception e) {
//                       // 加业务回滚
//                       System.err.println("我要回滚了，因为=>"+e.getMessage());
//                    }
//                    return (int)(Thread.currentThread().getId());
//                }
//            };
//            cs.add(c);
//        }
        
        
        // way one 
        // 如果第一个任务时间过长，可能后面都要等待，变成串行
//            List<Future<Object>> invokeAll = pool.invokeAll(cs);
//            for (Future<Object> future : invokeAll) {
//                future.get(0, TimeUnit.SECONDS);
//            }
        
        
        // way two 
        // 使用blockingqueue作为阻塞队列，但是结果与上面貌似类似啊，都是串行
//        completionService = new ExecutorCompletionService<Integer>(pool);
//        for (Callable<Integer> task : cs) {
//            completionService.submit(task);
//        }
//        try {
//            for (int i = 0; i < cs.size(); i++) {
//                System.out.println("ExecutorCompletionService ="+ completionService.take().get());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        
        
        
        // way three
        // supply 支持返回值
//        CompletableFuture.supplyAsync(() -> 200 , pool)
//        // 出异常的时候不执行
//        .thenApply(new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer t) {
//                System.err.println("我是任务2,计算结果是" + t);
//                return 100;
//            }
//        }).
//        // 出异常继续执行
//        handle(new BiFunction<Integer, Throwable, Integer>() {
//            @Override
//            public Integer apply(Integer t, Throwable u) {
//                // TODO 自动生成的方法存根
//                return null;
//            }
//            
//        })
//        .whenComplete(new BiConsumer<Integer, Throwable>() {
//            @Override
//            public void accept(Integer t, Throwable u) {
//                System.err.println("任务 完成");
//            }
//        });
        
    }
}
