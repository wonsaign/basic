package com.learn.java.lang.wangs.base.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.learn.java.lang.wangs.base.annotation.RepeatAnnotation.MyAnnotation;
import com.learn.java.lang.wangs.base.test.C1;

public class AnnotationUtil {

	public static boolean testAnno(String declaredName) {
	    try {
	    	Class<?> c1 = C1.class;
	    	MyAnnotation[] ms = c1.getAnnotationsByType(MyAnnotation.class);
	    	for (MyAnnotation a : ms) {
				System.out.println(a.value());
			}
	    	
	        for (Method method : AnnotationUtil.class
	            .getClassLoader()
	            .loadClass(declaredName) 
	            .getMethods()) {
	        	// checks if MethodInfo annotation is present for the method
	            if (method.isAnnotationPresent(MyAnnotation.class)) {
	                try {
	                	// iterates all the annotations available in the method
	                    for (Annotation anno : method.getDeclaredAnnotations()) {
	                        System.err.println("Annotation in Method "+ method + " : " + anno);
	                    }
	                    MyAnnotation methodAnno = method.getAnnotation(MyAnnotation.class);
	                    // TODO:业务逻辑处理
	                    MyAnnotation p = method.getAnnotation(MyAnnotation.class);
			        	System.err.println(p.value());
	                } catch (Throwable ex) {
	                	ex.printStackTrace();
	                }
	            }
	        }
        } catch (Exception e) {
            e.printStackTrace();
        }
	    return false;
	}
}
