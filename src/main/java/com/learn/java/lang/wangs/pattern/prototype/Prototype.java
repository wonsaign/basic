package com.learn.java.lang.wangs.pattern.prototype;

public class Prototype implements Cloneable {

    public Prototype() {
        System.out.println("构造中。。。。");
    }

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

}
