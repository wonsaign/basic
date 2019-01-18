package com.learn.java.lang.wangs.util.jdk8;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class JDK8Util {


    public static void main(String[] args) {
        Set<Object> a = new HashSet<>();
        a.add(2);
        // Set<?> 与 Set<Object> 的区别是,带?的表示是一个受检类型,并且是包含未知对象类型的集合
        Set<? super Number> aa = new HashSet<>();
        aa.add(2);
        System.err.println("hello world");
    }

    static Supplier<?> SupplierTest(){
        A a = new A();
        Supplier<A> s0 = A::valueOfA; // lambda表达式必须是接口
        Supplier<A> s1 = () -> A.valueOfInt(new int[]{1,2,3}); // lambda表达式必须是接口
        //Supplier<A> s2 = () -> a::valueOfInt;// 函数式接口必须有参数,比如(a),才可以使用这个
        Objects.requireNonNull(s0.get());
        return s1;
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