package com.learn.java.lang.wangs.util.jdk10;

import java.util.ArrayList;
import java.util.List;

public class JdkTen {

	static void newTry() {
		@SuppressWarnings("unused")
		var x = new ArrayList<String>();
	}
	public static void main(String[] args) {
		newTry();
	}

}
