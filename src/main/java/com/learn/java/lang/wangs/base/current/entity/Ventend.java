package com.learn.java.lang.wangs.base.current.entity;

public class Ventend implements IValue {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int v;

    public Ventend(int v) {
        super();
        this.v = v;
    }

    public int getV() {
        return v;
    }

    public static Ventend getVentend(Kentend k) {
        return new Ventend(caculele(k.getK()));
    }

    public void setV(int v) {
        this.v = v;
    }

    private static int caculele(int v) {
        return (v * 1000) / 14;
    }

}
