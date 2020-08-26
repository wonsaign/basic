package com.learn.java.lang.wangs.base.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.learn.java.lang.wangs.util.QString;

/**
 * 根据反射获取方法
 *
 * @author Adm
 */
public class Clazz {

    public static <T> String getMethodValue(Class<T> clazz, String... strings) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        //clazz.get
        for (String s : strings) {
            if (s.length() == 1) {
                s = s.substring(0, 1).toUpperCase();
            } else {
                s = s.substring(0, 1).toUpperCase() + s.substring(1);
            }
            String methodName = "get" + s;
            Method method = clazz.getMethod(methodName);
            @SuppressWarnings("unchecked")
            T result = (T) method.invoke(clazz.getDeclaredConstructor().newInstance());
            if (QString.isNullOrEmpty(result)) {
                return methodName;
            }
        }
        return "";
    }
}
