package com.learn.java.lang.wangs.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynProxy implements InvocationHandler {

    private Object obj;

    public DynProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理开始");
        System.out.println("我自己加了方法");
        method.invoke(obj, args);
        System.out.println("代理结束");
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T newMapperProxy(Class<? extends T> t) {
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(), new DynProxy(t));
    }
}
