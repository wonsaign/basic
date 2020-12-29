package com.learn.java.lang.wangs.obj;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Oeq {


    static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);

    @Override
    public int hashCode() {
        return 1;
    }

    public static void main(String[] args) {
//        Oeq q1 = new Oeq();
//        Oeq q2 = new Oeq();
//
//        System.out.println(q1 == q2);
//        System.out.println(q1.equals(q2));

        for (int i = 0; i < 10; i++) {
            bq.offer(i);
        }
        for (int i = 0; i < 10; i++) {
            bq.poll();
        }

        System.out.println(bq);
    }
}
