package com.learn.java.lang.wangs.base.util;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class ItoratorTest {

    public static void main(String[] args) {
        
        
        List<String> newArrayList = Lists.newArrayList("wangs","sai");
        
        
        for (Iterator<String> it = newArrayList.iterator(); it.hasNext(); ) {
            String name = it.next();
            if(name.equals("wangs")) {
                it.remove();
            }
//            if(name.equals("wangs")) {
//                it.remove();
//            }
        }
    }
}
