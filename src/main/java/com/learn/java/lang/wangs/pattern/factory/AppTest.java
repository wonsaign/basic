package com.learn.java.lang.wangs.pattern.factory;

public class AppTest {

    public static void main(String[] args) {
        HumanFactoryExtender1 hf1 = new HumanFactoryExtender1();
        HumanExtender1 human1 = hf1.createHuman(HumanExtender1.class);
        human1.say();
        human1.getColor();
    }
}
