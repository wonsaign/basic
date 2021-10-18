package com.learn.java.lang.wangs.base.rmi.client;

import com.learn.java.lang.wangs.base.rmi.api.Task;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pi implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 6423132751463336420L;

    @Override
    public BigDecimal execute() {
        return new BigDecimal(Math.PI);
    }
}
