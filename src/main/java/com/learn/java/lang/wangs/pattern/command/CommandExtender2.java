package com.learn.java.lang.wangs.pattern.command;

public class CommandExtender2 extends Command {

    // 指定命令的接收者
    private Revicer revicer;

    public CommandExtender2() {
        revicer = new RevicerExtender2();
    }

    @Override
    public void excute() {
        revicer.doSomething();
    }
}
