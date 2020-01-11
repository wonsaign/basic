package com.learn.java.lang.wangs.util;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        
        for (int i = 0; i < 20; i++) {
            t(2);
        }
    }
    
    public static void t(int i) {
        
        Random random = new Random();
        random.nextInt(5);
        int ii = -1;
        do {
            ii = random.nextInt(5) + 1;
        } while (ii == i);
        
        System.err.println(ii);
    }
    
}
