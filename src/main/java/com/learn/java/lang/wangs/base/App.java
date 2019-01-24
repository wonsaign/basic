package com.learn.java.lang.wangs.base;

//import java.util.Optional;
// 所有的类，都不能是private的
public class App extends Father{
	public int num = 3;
	public static void main(String[] args) {
		// argsInt(1,2);
		//  string();
		// new Obj().superClassName();
		// ((Obj)null).TsName();// 静态方法不依赖类的存在 
		//Father f = new Obj();
		//System.out.println(f.num);
		//new Obj().breakLoop();
		// Exe();
	}
	
	App(){
		this.method();
		num = 4;
	}
	
	static void  Exe() {
		// int i = 1/0;//未try
		try {
			System.exit(0);//强制退出
		}catch (Exception e) {
		}finally {
			System.out.println("上面两种情况我都不会执行");
		}
	}
	
	void breakLoop() {
		out:
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <5; j++) {
				if(j>=2) {
					break out;
				}
				System.out.println(j);
			}
			System.out.println("inner loop");
		}
		System.out.println("out loop");
	}
	
	public void method() {
		System.out.println("Objnum="+num);
	}

	static void TsName() {
		System.out.println("hello world");
	}
	@SuppressWarnings("unused")
	private void superClassName() {
		// super.getClass,调用的是父类Object的getClass(),是final和native的,而它的getName表示运行类的名称
		System.out.println(super.getClass().getName());
		// 每次运行，打印书序不同
		System.err.println(super.getClass().getSuperclass().getName());
	}
	
	static void string() {
		String a = "aaa";
		String b = new String(a);
		String c = "aaa";
		String d = new String(c);
		System.out.println(a==b);
		System.out.println(a.equals(b));
		System.out.println(a.hashCode()+"---"+b.hashCode());
		
		System.out.println(a==c);
		System.out.println(a.equals(c));
		System.out.println(c==d);
		System.out.println(b==d);
		System.out.println("---"+b.toString()+"---"+d.toString());
	}

	void non_static() {
		
	}
	
	static void argsInt(int ...a) {
		// jvm为可边长参数隐式创建数组，可通过数组访问
		System.out.println(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public int method(int i,int j) {
		return i+j;
	}
}
class Father{
	int num = 1;
	{
		System.out.println("Im father");
	}
	
//	static {
//		System.err.println("Im static father");
//	}
	Father(){
		this.method();
		num = 2;
	}
	public void method() {
		System.out.println("Objnum="+num);
	}
}


// 构造单例模式
class Singleton{
	// 构造方法私有化，外部无法调用
	private Singleton() {}
	// 如何拿到？ 通过方法取得，如何保证只有一份？
	// final 不可以
	// static 保证唯一
	// private 私有 外部不让用
	private static Singleton s;
	// 如果没有static ,就不能保证只有一个方法
	public static Singleton getSingleton() {
		if(s == null) {
			// 反射获取
//			try {
//				s = Singleton.class.newInstance();
//			} catch (InstantiationException | IllegalAccessException e) {
//			}
			// 其他调用是new不到，private自己可以new
			s = new Singleton();
		}
		return s;
	}
	
}
