package com.learn.java.lang.wangs.base.reflect;

import java.io.Serializable;

/**
 * @author wangsai
 */
public class Test implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                '}';
    }
}
