package com.learn.java.lang.wangs.base.inter.extenders;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Extenders {


    public static void main(String[] args) {
        Extenders e = new Extenders();

        List<A> as = new ArrayList<>();

        A a = new A();
        B b = new B();
//        b.b=2;
//        b.a=1;

        as.add(a);
        as.add(b);

        as.forEach(System.out::print);
        //as.add();
    }

}
