package com.learn.java.lang.wangs.test;

import com.learn.java.lang.wangs.test.inter.Inter;

public class InnerClass extends AbsImplInterface implements Inter {

	private int i ;
	static int h;
	void m1() {}
	static void m2() {}
	public int getI() {return i;}
	public void setI(int ii) {this.i = ii;}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Inter inter = new Inter() {
			@Override
			public void sayInterHello() {
				// TODO Auto-generated method stub
				
			}
			
		};
		@SuppressWarnings("unused")
		AbsImplInterface absImplInterface = new AbsImplInterface() {
			// 可有可无
			void sayAbsHello() {}
			@Override
			void absMehod() {
			}
			@Override
			public void sayInterHello() {
			}
		};
	}
	
	void method() {
		class methodIn{
			
		}
	}
	
	// 不依赖外部类的实例化
	static class staticIn{
		int getOuterInt() {
			//return i; cant
			return h;// 只能引用外部静态的
		} 
	}
	// 必须依赖外部类的实例化
	class normalIn{
		int getOuterInt() {
			return i;
		}
		int getAllInt() {
			return i+h;// 普通的都可以引用
		}
	}

	@Override
	void absMehod() {
	}
	@Override
	public void sayInterHello() {
	}
}
