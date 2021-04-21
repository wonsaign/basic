package com.learn.java.lang.wangs.base.stream.usedemo;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapUsed {

    public static void main(String[] args) {

        MapUsed mapUsed = new MapUsed();

        List<A> as = mapUsed.demoSample();

        List<A> collect = new ArrayList<>(as.stream().collect(Collectors.toMap(A::getId, v -> v, A::addInc)).values());

        collect.stream().forEach(System.out::print);

    }


    public List<A> demoSample(){
        A a1 = new A("a","yh", 1);
        A a2 = new A("a","mj", 13);
        A a3 = new A("b","yh", 12);
        A a4 = new A("b","mj", 1);
        A a5 = new A("c","yh", 19);
        A a6 = new A("c","mj", 4);
        A a7 = new A("d","yh", 1);
        A a8 = new A("d","mj", 3);
        A a9 = new A("e","yh", 1);

        List<A> list = Lists.newArrayList();

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);
        list.add(a8);
        list.add(a9);

        return list;
    }

    @Data
    @AllArgsConstructor
    class A{
        String id;
        String type;
        Integer sum;

        public A addInc(A o){
            this.sum += o.sum;
            return this;
        }
    }


}
