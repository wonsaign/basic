package com.learn.java.lang.wangs.base.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class RepeatAnnotation {

    @Retention(RUNTIME)
    @Target(METHOD)
    public @interface MyAnnotations {
        MyAnnotation[] value();// 名字必须是value
    }

    @Repeatable(value = MyAnnotations.class)
    @Retention(RUNTIME)
    @Target(METHOD)
    public @interface MyAnnotation {
        String value() default "mytest";
    }
}
