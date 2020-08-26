package com.learn.java.lang.wangs.base.inter;

public class Client {

    Inter inter;

    public Client() {
        super();
    }

    public Client(Inter inter) {
        super();
        this.inter = inter;
    }

    public void clientSayHi() {
        inter.sayInterHello();
    }
}
