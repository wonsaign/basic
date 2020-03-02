package com.learn.java.lang.wangs.base.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

    public static void main(String[] args) {
        
        
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
        map.put(4,2);
        
        for (Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getKey() == 1) {
                map.put(1, 20);
            }
        }
        
        for (Integer k : map.keySet()) {
            System.err.println(k + "!!!!" + map.get(k));
        }
    }
}
