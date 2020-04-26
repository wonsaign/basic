package com.learn.java.lang.wangs.util.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * 对象大小分析工具测试
 */
public class JOLTest {

    public static void main(String[] args) {
        JOLTestClass a = new JOLTestClass();
        a.id = 10;
        a.name = "hello";
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    public static class JOLTestClass{
        Integer id;
        String name;
    }
}
