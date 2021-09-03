package com.learn.java.lang.wangs.base.thread;

public class S{

    private static volatile S s;

    private int a;

    private S(){}

    public static S getInstance(){
        if(s == null){
            s = new S();
        }
        return s;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}