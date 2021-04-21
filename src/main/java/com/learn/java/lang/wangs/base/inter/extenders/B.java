package com.learn.java.lang.wangs.base.inter.extenders;

import lombok.Data;

@Data
public class B extends A{
    int b;

    @Override
    public String toString() {
        return "B{" +
                "b=" + b +
                ", a=" + a +
                '}';
    }
}
