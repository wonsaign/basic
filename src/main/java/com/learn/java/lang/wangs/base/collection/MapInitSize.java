package com.learn.java.lang.wangs.base.collection;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class MapInitSize {

    public static void main(String[] args) {
        int size = 750 * 10000;
        Map<String, Integer>  map = new HashMap(1000 * 10000);
        //Map<String, Integer>  map = Maps.newHashMapWithExpectedSize(size);
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            String ii = "" + i;
            map.put(ii, i);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);


        Map<String, Integer>  map1 = new HashMap();
        long l3 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            String ii = "" + i;
            map1.put(ii, i);
        }
        long l4 = System.currentTimeMillis();
        System.out.println(l4 - l3);
    }
}
