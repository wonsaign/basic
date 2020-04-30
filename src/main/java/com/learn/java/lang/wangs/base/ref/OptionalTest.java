package com.learn.java.lang.wangs.base.ref;

import java.math.BigDecimal;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        t();
    }

    public static void t(){
        //BigDecimal o = BigDecimal.TEN;
        BigDecimal o = null;
        BigDecimal orElse = Optional.ofNullable(o).orElse(BigDecimal.ZERO);
        System.out.println(orElse);
    }
}
