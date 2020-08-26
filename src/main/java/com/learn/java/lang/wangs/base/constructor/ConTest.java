package com.learn.java.lang.wangs.base.constructor;

class Base {

    int num = 1;

    public Base() {
        this.print();
        num = 2;
    }

    public void print() {
        System.out.println("Base num=" + num);
    }
}

class Sub extends Base {

    int num = 3;

    public Sub() {
        this.print();
        num = 4;
    }

    public void print() {
        System.out.println("Sub num=" + num);
    }
}

public class ConTest {

    public static void main(String[] args) {
        Base b = new Sub();
        // 属性是'相对静态'的,所以没有多态,比如口,鼻,眼,手,脚
        int a = b.num;// 属性没有多态的概念,所以就是2
        // 方法是'相对动态'的,所以会有多态,吃饭,看书,等等
        System.out.println(a);

        Sub bb = new Sub();
        int aa = bb.num;// 属性没有多态的概念,所以就是4
        System.out.println(aa);
    }

}
