package com.learn.java.lang.wangs.spring.shiro.bean;

public class ShiroBean {

    boolean status;

    Object authToken;


    public ShiroBean() {
    }

    public ShiroBean(boolean status, Object authToken) {
        super();
        this.status = status;
        this.authToken = authToken;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getAuthToken() {
        return authToken;
    }

    public void setAuthToken(Object authToken) {
        this.authToken = authToken;
    }


}
