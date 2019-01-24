package com.learn.java.lang.wangs.base.current;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Loop {

	public static void main(String[] args) throws IOException {
		String in;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("请输入（Y/N）：");
			in = sc.nextLine();
		}while (!"Y".equals(in)); 
			System.out.println("it yes");
		sc.close();
		
		for (int i = 8 , j = i; i < 10; i++,j--) {
			System.out.println("i="+i);
			System.out.println("j="+j);
		}
		@SuppressWarnings("unused")
		ReentrantLock rt = new ReentrantLock();
		
	}

}
