package com.learn.java.lang.wangs.base;

public enum EnumDemo {

    DOG(11),
    CAT(12),
    PIG(14),
    TIGER(18),
    ROW(20);


    private int value;

    private EnumDemo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    static class EnumTest {
        public static void main(String[] args) {
            EnumDemo[] values = EnumDemo.values();
            for (EnumDemo enumDemo : values) {
                System.err.println(enumDemo);
            }
        }
    }
}
