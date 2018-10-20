package com.learn.java.lang.wangs.base.nt;

public class NativeTest {

	static {
		System.loadLibrary("helloNative");
	}
	
	public static native void sayHello();
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		/// new NativeTest().sayHello();
	}
}
