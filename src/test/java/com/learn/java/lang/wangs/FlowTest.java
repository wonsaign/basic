package com.learn.java.lang.wangs;

public class FlowTest {

//	public void m() {
//		long i = (int)3.9;
//		i %= 2;
//	}
	
	// i++ 和 ++i
//	public void m2() {
//		int i = 0;// 赋值'=' 在java字节码中是istore
//		i = i++; // 
//		//System.out.println(i);
//		// i = ++i; // <==> ++i;
//		i = ++i; // 这个赋值动作,在字节码层面是iload_1,istore_2,先从局部变量表中加载i,再将局部变量ii存入局部变量表中2号位置
//		
//		// i=i++ 和i=++i 相同的是栈帧的局部变量表中的数字加1
//		// 唯一不同就是 :
//		// i=i++是iload,iinc
//		// i=++i是iinc,iload
//		//i = i+=2;
//		//System.out.println(i);
//	}
	
	public void m3() {
		int i = 1;
	//	int kk = i +2;
	//	int j = (i++)+i/3;//iload,iinc,iload
		i = i++ + ++i + i++ + ++i ;
		
	//	int j = i+(++i)/3;//iload,iinc,iload
    //  System.out.println(j +"~~~"+ i);
		System.err.println(i);
	}
	
//	public void eqAnd(){
//		String a = "test";
//		String b = "te"+new String("st");
//		b.hashCode();
//		boolean r1 = a==b;
//		boolean r2 = a.equals(b);
//	//	System.out.println(a==b);
//	//	System.out.println(a.equals(b));
//	}
	public static void main(String[] args) {
		new FlowTest().m3();
//		FlowTest f1= new FlowTest();
//		FlowTest f2= new FlowTest();
//		f1.equals(f2);
//		Set<FlowTest> hs = new HashSet<>();
//		hs.add(f2);
//		hs.add(f1);
	}
//	@Override
//	public int hashCode() {
//		System.out.println("我调用了HashCode");
//		return super.hashCode();
//	}
//	@Override
//	public boolean equals(Object obj) {
//		System.out.println("我重写了Equals");
//		return super.equals(obj);
//	}
	
}
