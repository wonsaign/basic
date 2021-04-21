package com.learn.java.lang.wangs.base.exception;

import java.util.concurrent.CopyOnWriteArrayList;

public class ExceptionReturnTest {

    private static int count(int a) // {
            throws Exception {
        try {
            CopyOnWriteArrayList x = new CopyOnWriteArrayList();
            return 10 / a;
        } finally {
            System.out.println("方法终结");
            return 0;
        }
        //return 0;
    }

    public static void main(String[] args) throws Exception {
            try {
            System.out.println(count(1));
        } catch (Exception e) {
//			System.out.println(e.getMessage());
            System.out.println("main exception");
            throw new Exception("main exception");
        } finally {
            System.out.println("main finally");
        }
    }

}
