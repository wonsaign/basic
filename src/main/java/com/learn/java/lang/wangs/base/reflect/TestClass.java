package com.learn.java.lang.wangs.base.reflect;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author wangsai
 */
public class TestClass extends BasicClass<Test>{

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        Test t = tc.getT();
        t.setId(1);
        System.out.println("t = " + t);
        HashMap<String, Object> values = Maps.newHashMap();
        values.put("id",10);
        Test update = tc.update(values);

        System.out.println(update);
    }
}
