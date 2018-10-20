package com.learn.java.lang.wangs.pattern.command;

public class CommandExtender1 extends Command{

	// 指定命令的接收者
	private Revicer revicer;
	
	public CommandExtender1() {
		revicer = new RevicerExtender1();
	}
	
	@Override
	public void excute() {
		revicer.doSomething();
	}

}
