package com.learn.java.lang.wangs.base.string;

public class StringEq {

    public static void main(String[] args) {
        String x = "string";
        String y = "string";
        String z = new String("string");
        System.out.println(x==y);
        System.out.println(x==z);
        z.intern();
        System.out.println(x.equals(y));
        System.out.println(x.equals(z));
    }
}
