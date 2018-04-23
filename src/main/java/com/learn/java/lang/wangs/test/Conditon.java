package com.learn.java.lang.wangs.test;

import java.io.IOException;
import java.util.Scanner;

public class Conditon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入（Y/N）：");
		String in = sc.nextLine();
		switch (in) {
		case "Y":
			System.out.println("no");
			break;
		default:
			System.out.println("yes");
			break;
		}
		sc.close();
	}

}
