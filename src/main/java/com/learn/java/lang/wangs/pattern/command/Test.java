package com.learn.java.lang.wangs.pattern.command;

public class Test {


    public static void main(String[] args) {
        Command c1 = new CommandExtender1();
        Command c2 = new CommandExtender2();
        Invoker i = new Invoker() {
        };
        i.setCommand(c1);
        i.action();

        i.setCommand(c2);
        i.action();
    }
}
