package com.learn.java.lang.wangs.util.jdk10;

import java.util.ArrayList;
import java.util.List;

public class NewTry {

	static void newTry() {
		@SuppressWarnings("unused")
		var x = new ArrayList<String>();
		
		List<String> s = List.of("a","b","c");
		//x = (ArrayList<String>) s;
		
		System.out.println(s);
	}
	public static void main(String[] args) {
		newTry();
	}

}
