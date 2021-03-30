package com.learn.java.lang.wangs.base.reflect;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author wangsai
 */
public class BasicClass<T extends Serializable> {


    public BasicClass(){
        System.out.println(getGenericClass(getClass(), 0));
    }

    public T getT(){
        return getInstance();
    }

    @SuppressWarnings("unchecked")
    protected static <T> Class<T> getGenericClass(Class<?> clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        // 如果未定义类型
        if (genType != null && genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            if ((params != null) && (params.length >= (index - 1))) {
                return (Class<T>) params[index];
            }
        }
        return null;
    }

    public T update(Map<String, Object> values){
        T t = getInstance();
        Class tc = t.getClass();
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            String filedName = entry.getKey();
            Object v = entry.getValue();
            try {
                Field field = tc.getDeclaredField(filedName);
                field.setAccessible(true);
                field.set(t, v);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                continue;
            }
        }
        return t;
    }

    public T getInstance() {
        try {
            // 每行新创建一个对象保存
            ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
            Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
