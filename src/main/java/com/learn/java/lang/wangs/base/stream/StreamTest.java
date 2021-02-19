package com.learn.java.lang.wangs.base.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class StreamTest {


    public static void main(String[] args) {

        List<String> ss = Lists.newArrayList("a", "b", "c");

        List<String> new_l = ss.stream()
                .sorted((e1, e2) -> -1)
                .filter(s -> s.equalsIgnoreCase("a"))
                .map(s -> s)
                .limit(1)
                .collect(Collectors.toList());

        System.out.println(new_l);

//        List<String> s_new = new ArrayList<>();
//        Collections.sort(ss, (e1,e2)->-1);
//        for (String s: ss) {
//            if(!s.equalsIgnoreCase("a")){
//                continue;
//            }
//            if(s_new.size() > 1){
//                break;
//            }
//            s_new.add(s);
//        }
    }
}
