package com.learn.java.lang.wangs.rebuild;

class Person2{
//	public static final int O = 0;
//	public static final int A = 1;
//	public static final int B = 2;
//	public static final int AB = 3;
//	private int bloodGroup;
//	public int getBloodGroup() {
//		return bloodGroup;
//	}
//	public void setBloodGroup(int bloodGroup) {
//		this.bloodGroup = bloodGroup;
//	}
//	public Person2(int bloodGroup) {
//		super();
//		this.bloodGroup = bloodGroup;
//	}

	
//	public static final int O = BloodGroup.O.getCode();
//	public static final int A = BloodGroup.A.getCode();
//	public static final int B = BloodGroup.B.getCode();
//	public static final int AB = BloodGroup.AB.getCode();
//	
//	public Person2(int bloodGroup) {
//		this.bloodGroup = BloodGroup.code(bloodGroup);
//	}
//	public int getBloodGroupCode() {
//		return bloodGroup.getCode();
//	}
//	public void setBloodGroupCode(int bloodGroup) {
//		this.bloodGroup = BloodGroup.code(bloodGroup);
//	}
	
	private BloodGroup bloodGroup;
	
	
	public Person2(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
}
class BloodGroup{
	public static final BloodGroup O = new BloodGroup(0);
	public static final BloodGroup A = new BloodGroup(1);
	public static final BloodGroup B = new BloodGroup(2);
	public static final BloodGroup AB = new BloodGroup(3);
	public final int code;
	public BloodGroup(int code) {
		this.code = code;
	}
	
	// 工厂模式
	public static final BloodGroup[] value = {A,B,O,AB};
	// 工厂模式
	public static BloodGroup code(int code) {
		return value[code];
	}
	public int getCode() {
		return code;
	}
}
/**
 * when : 任何接受类型码(类型常量)作为参数的函数,有可能产生bug
 * @author wangs
 *
 */
public class ReplaceCodewithClass {
	public static void main(String[] args) {
		// 不影响宿主行为:偏属性
		// Person2 p2 = new Person2(Person2.A); // 编译器不会检测常量数值
		Person2 p2 = new Person2(BloodGroup.A); // 编译器会对类进行检测
		p2.getBloodGroup().getCode();
		p2.setBloodGroup(BloodGroup.AB);
	}
}
