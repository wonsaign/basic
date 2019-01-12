package com.learn.java.lang.wangs.base.ref;

import java.lang.ref.SoftReference;

public class RefPricties{   

    public static void main(String[] args) {
        System.out.println("开始");
        A a = new A();
        SoftReference<A> ref = new SoftReference<A>(a);
        a = null;
        if(ref != null){
            a = ref.get();
        } else {
            a = new A();
            ref = new SoftReference<A>(a);
        }
        System.err.println("结束");
    }
}
class  A {
    int [] a;
    public A(){
        a = new int[1000000];
    }
}