package com.learn.java.lang.wangs.base.string;

public class EqualAndSymbolEqual {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setI(128);
        b.setI(128);
        boolean fa = a.getI() == b.getI();
        System.out.println(fa);
        System.err.println(a.getI().equals(b.getI()));

        a.setI(127);
        b.setI(127);
        boolean tr = a.getI() == b.getI();
        System.out.println(tr);
        System.err.println(a.getI().equals(b.getI()));
    }
}

class A {
    private Integer i;

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}

class B {
    private Integer i;

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}