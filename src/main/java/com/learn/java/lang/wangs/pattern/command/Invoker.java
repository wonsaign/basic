package com.learn.java.lang.wangs.pattern.command;

public abstract class Invoker {
	private Command command;
	
	public void setCommand(Command c) {
		this.command = c;
	}
	
	public void action() {
		command.excute();
	}
}
