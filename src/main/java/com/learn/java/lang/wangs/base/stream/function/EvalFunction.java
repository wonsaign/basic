package com.learn.java.lang.wangs.base.stream.function;


import com.learn.java.lang.wangs.base.stream.MyStream;

/**
 * @Author xiongyx
 * @Date 2019/3/6
 */
@FunctionalInterface
public interface EvalFunction<T> {

    /**
     * stream流的强制求值方法
     * @return 求值返回一个新的stream
     * */
    MyStream<T> apply();
}
