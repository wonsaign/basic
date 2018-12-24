package com.learn.java.lang.wangs.rebuild;

//@Switch
class Switch {
	public static final String PACKAGE_NAME = "com.learn.java.lang.wangs.rebuild.";
	
	public Switch getPolyContent(String caseName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String clazzName = PACKAGE_NAME + caseName; 
		Class<?> clazz = Class.forName(clazzName);
		// this is init , must be null
		return (Switch)clazz.newInstance();
	}
	void doCase() {};
}
//@Case
class CaseASub extends Switch{
	@Override
	void doCase() {System.out.println("A");};
}
//@Case
class CaseBSub extends Switch{
	@Override
	void doCase() {System.out.println("B");};
}
//@Case
class CaseCSub extends Switch{
	@Override
	void doCase() {System.out.println("C");};
}

public class SwitchReplace {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Switch s = new Switch();
		s.getPolyContent("CaseCSub").doCase();
	}
}