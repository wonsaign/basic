package com.learn.java.lang.wangs.base.abstracted;

public class AbstractTest {

    public static void main(String[] args) {
        // 匿名实现类
        AbstractB aB = new AbstractB(){
            @Override
            void imA() {
                System.out.println("我是A的抽象方法");
            }

            @Override
            void imAImpl() {
                System.out.println("我重写了A的默认实现");
            }
        };
        aB.imA();
        aB.imAImpl();

        // 又是匿名内部类，然后可以调用接口里的东西，感觉用的太好了
        Iter.ImplT it = new Iter.ImplT("lambda") {
            @Override
            public void begin() {
                str.length();
            }

            @Override
            public void end() {
                str.toString();
            }
        };
    }
}
