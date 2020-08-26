package com.learn.java.lang.wangs.rebuild;

import java.lang.reflect.InvocationTargetException;

//@Switch
class Switch {
    public static final String PACKAGE_NAME = "com.learn.java.lang.wangs.rebuild.";

    public Switch getPolyContent(String caseName)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        String clazzName = PACKAGE_NAME + caseName;
        Class<?> clazz = Class.forName(clazzName);
        // this is init , must be null
        return (Switch) clazz.getDeclaredConstructor().newInstance();
    }

    void doCase() {
    }

    ;
}

//@Case
class CaseASub extends Switch {
    @Override
    void doCase() {
        System.out.println("A");
    }

    ;
}

//@Case
class CaseBSub extends Switch {
    @Override
    void doCase() {
        System.out.println("B");
    }

    ;
}

//@Case
class CaseCSub extends Switch {
    @Override
    void doCase() {
        System.out.println("C");
    }

    ;
}

public class SwitchReplace {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        Switch s = new Switch();
        s.getPolyContent("CaseCSub").doCase();
    }
}