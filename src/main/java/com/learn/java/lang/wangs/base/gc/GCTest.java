package com.learn.java.lang.wangs.base.gc;

public class GCTest {

    
//    -Xms20m
//    -Xmx26m
//    -XX:+PrintGCDetails
//    -verbose:gc
//    -Xloggc:d:/gc.log
//    -Xmn10M
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 30; i++) {
            byte[] _size = new byte[i*1024*1024];
        }
        
    }
}
