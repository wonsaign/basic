package com.learn.java.lang.wangs.base.current;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EService {

    private final static ExecutorService s = Executors.newFixedThreadPool(20);
    private static FutureTask<Integer> ff;

    private static int i = 0;
    private static Thread t1;
    private static Thread t2;
    @SuppressWarnings("unused")
    private static BlockingDeque<Integer> b;

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        try {
            Future<?> f = s.submit(new Runnable() {
                @Override
                public void run() {
                    i++;
                }
            });
            //		boolean mayInterruptIfRunning = true;
            //		f.cancel(mayInterruptIfRunning);
            System.out.println(f.isCancelled());
            s.execute(new Runnable() {
                @Override
                public void run() {
                    i++;
                }
            });

            System.out.println(i);
            s.shutdown();
            // way 1
            // s.shutdown();
            // s.awaitTermination(2, TimeUnit.SECONDS);
            // 有“毒” 对象


            ff = new FutureTask<Integer>(new Runnable() {
                @Override
                public void run() {
                    i++;
                }
            }, Integer.valueOf(1));
            System.out.println(ff.isDone());
            System.err.println(ff.get(1, TimeUnit.SECONDS));
        } catch (TimeoutException te) {
//			te.printStackTrace();
            System.out.println("干完了么" + ff.isDone());
            System.out.println(i);
        } catch (Exception e) {
        }
    }

    public static void start() {
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                i++;
            }
        });
        t1.start();
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                i--;
            }
        });
        t2.start();
    }

    public static void stop() {
        t2.interrupt();
    }
}
