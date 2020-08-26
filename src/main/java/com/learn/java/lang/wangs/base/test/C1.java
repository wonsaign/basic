package com.learn.java.lang.wangs.base.test;

import com.learn.java.lang.wangs.base.annotation.RepeatAnnotation.MyAnnotation;

public class C1 {
    int value;


    public int setV(int newV) {
        int old = value;
        value = newV;
        return old;
    }

    @MyAnnotation("one")
    @MyAnnotation("two")
    public void V(String s) {
        System.out.println("String");
    }

    //    public void V(Byte s) {
//    	System.out.println("Object");
//    }
    public void V(Object s) {
        System.out.println("Object");
    }

    public void lambT(C1 c1) {
        System.out.println("Lambda");
    }
}
