package com.learn.java.lang.wangs.base.ref;

/**
 * 引用传递
 *
 * @author wangs
 */
public class RefTransmit {

    public static void main(String[] args) {
        B b = new B();
        b.setI(1);
        transmitTest(b);

        System.err.println(b.getI());
    }

    public static void transmitTest(B b) {
        B b_new = new B();
        b_new.setI(10);

        b = b_new;
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