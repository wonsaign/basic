package com.learn.java.lang.wangs.rebuild;

/**
 * learn 状态模式
 * @author wangs
 *
 */

//rebuilding
class Employee{
//	private  int intType;
//	static final int A = 1;
//	static final int B = 2;
//	static final int C = 3;
	
//	public int getIntType() {
//		return intType;
//	}
//	public void setIntType(int intType) {
//		this.intType = intType;
//	}
//	int payAmount() {
//		switch (getIntType()) {
//		case A:
//			return 1000;
//		case B:
//			return 2000;
//		case C:
//			return 3000;
//		default:
//			throw new RuntimeException("Incorret Employee");
//		}
//	}


	EmployeeType type;
	public int getIntType() {
		return type.getTypeCode();
	}
	int payAmount() {
//		switch (getIntType()) {
//		case EmployeeType.A:
//			return 1000;
//		case EmployeeType.B:
//			return 2000;
//		case EmployeeType.C:
//			return 3000;
//		default:
//			throw new RuntimeException("Incorret Employee");
//		}
		// 将方法的实现,交给'间接继承类',由其内的方法完成
		return type.payAmount(this);
	}	
	public void setIntType(int intType) {
//		switch (intType) {
//			case A:
//				type = new Engineer();
//				break;
//			case B:
//				type = new Manager();
//				break;
//			case C:
//				type = new Saleman();
//				break;
//			default:
//				throw new RuntimeException("Incorret Employee");
//		}
		// 静态工厂
		type = EmployeeType.newType(intType);
		
	}
	
}

abstract class EmployeeType{
	static final int A = 1;
	static final int B = 2;
	static final int C = 3;
	// 与上面返回类型是一样的
	abstract int getTypeCode();	
	static EmployeeType newType(int code) {
		// like me  use 我也用了反射啊兄弟...
		switch (code) {
		case A:
			return new Engineer();
		case B:                
			return new Manager();
		case C:
			return new Saleman();
		default:
			throw new RuntimeException("Incorret Employee");
		}
	}
	
	abstract int payAmount(Employee emp);
}
class Engineer extends EmployeeType{
	@Override
	int getTypeCode() {
		//return Employee.A;
		return EmployeeType.A;
	}
	@Override
	int payAmount(Employee emp) {
		return 1000;
	}
}
class Manager extends EmployeeType{
	@Override
	int getTypeCode() {
		//return Employee.B;
		return EmployeeType.B;
	}
	@Override
	int payAmount(Employee emp) {
		return 2000;
	}
}
class Saleman extends EmployeeType{
	@Override
	int getTypeCode() {
		//return Employee.C;
		return EmployeeType.C;
	}
	@Override
	int payAmount(Employee emp) {
		return 3000;
	}
}


public class RepalceState {
	public static void main(String[] args) {
		Employee e = new Employee();	
		e.setIntType(2);
		System.out.println(e.payAmount());
	}
}
