package com.learn.java.lang.wangs.base.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConMap {

    static Map<String, String> map = new ConcurrentHashMap();

    public static void main(String[] args) {
        for (int i = 0; i < 13; i++) {
            int key = i * 11 + 1;
            map.put(String.valueOf(key), String.valueOf(i));
        }
    }
}
