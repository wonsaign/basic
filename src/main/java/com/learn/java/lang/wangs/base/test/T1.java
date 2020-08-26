package com.learn.java.lang.wangs.base.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

import com.learn.java.lang.wangs.base.annotation.AnnotationUtil;

public class T1 {


    public static void main(String[] args) {
        //	System.out.println(DateTimeUtil.format("YYMMDD",new Date()));
        //	System.out.println(String.valueOf((int)((Math.random()*9+1)*1000)));

        C1 c = new C1();
        Type superClass = c.getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) { // 父类有没有被参数化(泛型T->Student/Course... 就是泛型的参数化)
            @SuppressWarnings("unused")
            Type[] types = ((ParameterizedType) superClass).getActualTypeArguments();
            // types -> Student/Course...
            System.out.println("yes ParameterizedType ");
        }
        c.setV(20);
        System.out.println(c.value);

        c.V(null);
        c.V((Object) null);
        AnnotationUtil.testAnno("com.learn.java.lang.wangs.base.test.C1");
        int[] num = {1, 0, -1, 10, 9, -3, 7};
        int[] num2 = new int[10];
        maopaoSort(num, 1, 7);
        maopaoSort(num2, 1, 7);
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(num2));
    }


    static void maopaoSort(int[] a, int begin, int end) {
        if (end - begin <= 0) {
            return;
        }
        for (int i = begin - 1; i < end - 1; i++) {
            for (int j = i; j < end - 1; j++) {
                int temp = 0;
                if (a[j] - a[j + 1] > 0) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

}
