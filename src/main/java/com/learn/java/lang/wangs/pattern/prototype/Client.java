package com.learn.java.lang.wangs.pattern.prototype;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p = new Prototype();
        @SuppressWarnings("unused")
        Prototype pp = p.clone();

    }
}
