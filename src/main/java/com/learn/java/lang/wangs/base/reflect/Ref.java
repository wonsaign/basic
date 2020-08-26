package com.learn.java.lang.wangs.base.reflect;

import java.lang.reflect.Field;

public class Ref {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ReadOnly r = new ReadOnly();
        Field f = r.getClass().getDeclaredField("i");
        f.setAccessible(true);
        f.setInt(r, 30);
        System.out.println(r.getI());
    }

}

class ReadOnly {
    private int i = 20;// 基本类型不行？

    //	private Integer i = 20;
    public int getI() {
        return i;
    }
}