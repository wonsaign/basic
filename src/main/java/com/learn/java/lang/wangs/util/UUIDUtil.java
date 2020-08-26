package com.learn.java.lang.wangs.util;

import java.util.UUID;

public class UUIDUtil {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(UUID.randomUUID().toString().substring(0, 8));
        }
        UUID.randomUUID();
        System.out.println(UUID.randomUUID().toString().substring(0, 16));
        System.out.println(5 / 3);
        System.out.println(Math.floor(5 / 3));
        System.out.println(-5 / 3);
        System.out.println(t(5, 3));
        System.out.println(t(-5, 5));
        System.out.println(t(-5, 3));
    }

    static int t(int x, int y) {
        int r = x / y;
        if ((x ^ y) < 0 && (r * y) != x) {
            r--;
        }
        return r;
    }
}
