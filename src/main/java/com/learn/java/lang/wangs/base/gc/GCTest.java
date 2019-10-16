package com.learn.java.lang.wangs.base.gc;

public class GCTest {

    
    public static void main(String[] args) {
        
        for (int i = 0; i < 30; i++) {
            byte[] _size = new byte[i*1024*1024];
        }
        
    }
}
