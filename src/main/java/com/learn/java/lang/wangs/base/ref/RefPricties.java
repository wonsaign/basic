package com.learn.java.lang.wangs.base.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class RefPricties{   

    public static void main(String[] args) {
        System.out.println("begin");
        A a = new A();
        SoftReference<A> softref = new SoftReference<A>(a);
        WeakReference<A> weakref = new WeakReference<A>(a);
        if(softref.get() != null){
            a = softref.get(); // 内存够用,可以直接干
        } else {
            a = new A(); // 内存吃紧,软引用被Jvm回收 重新构建
            softref = new SoftReference<A>(a);
        }
        
        System.err.println(a);
        System.err.println("end");
    }
}
class  A {
    static A valueOfA(){
        return new A();
    }
    static A valueOfInt(int[] a){
        return new A(a);
    }
    public A(){
        super();
    }
    int [] a;
    public A(int[] a){
        this.a = a;
    }
}