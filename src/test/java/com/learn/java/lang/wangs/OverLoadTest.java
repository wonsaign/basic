package com.learn.java.lang.wangs;

public class OverLoadTest {

//	public static String result = "";

    public static void main(String[] args) {
//			BB bb = new BB();
//			bb.f();
//			bb.f(bb.aa);
//			;
//		fi(0);
//		fi(1);
//		System.out.println(result);
        // Class<Integer> cz = Integer.TYPE;
        // cz = int.class;
        System.out.println(intest());
    }

//	public static void fi(int i) {
//		try {
//			if(i == 1){
//				throw new Exception("E");
//			};
//		} catch (Exception e) {
//			result += "2";
//			//return;
//		}finally {
//			result += "3";
//		}
//		result += "4";
//	}


    public static int intest() {
        try {
            return 1;
        } catch (Exception e) {
            return 0;
        } finally {
            System.out.println("finally");
//			return 3; // 编译器会优化
        }
    }
}

class AA {
    int aa = 1;

    public void f() {
        System.out.println(this.getClass().getName());
    }

    ;
}

class BB extends AA {
    public void f(int i) {
        System.out.println(this.getClass().getName() + ":" + i);
    }

    ;
}
