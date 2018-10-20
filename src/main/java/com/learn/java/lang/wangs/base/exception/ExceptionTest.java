package com.learn.java.lang.wangs.base.exception;

public class ExceptionTest {

	private static int count(int a) // {
			 throws Exception{
		try {
			return 10/a;
		} catch (Exception e) {
			System.out.println("捕获到了异常");
			throw new Exception("方法异常");
		}finally {
			System.out.println("方法终结");
		}
		//return 0;
	}
	
	public static void main(String[] args) throws Exception{
		try {
			count(0);
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			System.out.println("main exception");
			throw new Exception("main exception");
		}finally {
			System.out.println("main finally");
		}
	}
	
}
