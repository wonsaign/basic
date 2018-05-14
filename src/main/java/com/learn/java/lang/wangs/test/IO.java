package com.learn.java.lang.wangs.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class IO {
	public static void main(String[] args) throws IOException {
		read();
	}
	
	static void write() throws IOException {
		FileOutputStream fo = new FileOutputStream(new File("d://abc.txt"));
		String s = "hello";
		byte[] b = s.getBytes(Charset.forName("UTF-8"));
		fo.write(b);
		fo.close();
	}
	
	static void read() throws IOException {
		@SuppressWarnings("resource")
		FileInputStream fi = new FileInputStream(new File("d://abc.txt"));
		int line = fi.read();
		try {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
			if(line > -1) {
				System.out.println(line);
		}
		}catch (Exception e) {
		}finally {
			if(fi != null) {
				fi.close();
			}
		}
	}
}
