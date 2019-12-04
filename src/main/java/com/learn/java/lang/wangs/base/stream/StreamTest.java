package com.learn.java.lang.wangs.base.stream;

import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class StreamTest {

    
    
    public static void main(String[] args) {
        
        List<String> ss = Lists.newArrayList("a","b","c");
        
        // 并行流，使用阻塞队列进行控制
        Stream<String> parallelStream = ss.parallelStream();
        
    }
}
