package com.learn.java.lang.wangs.base.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest {

    public static void main(String[] args) {

        Stu s1 = new Stu();
        s1.setId(1);
        s1.setName("zhang");


        Stu s2 = new Stu();
        s2.setId(2);
        s2.setName("li");


        List<Stu> stus = Lists.newArrayList(s1, s2);


        Map<Integer, Stu> collect = stus.stream().collect(Collectors.toMap(Stu::getId, k -> k));

        for (Integer integer : collect.keySet()) {
            collect.get(integer).setName("wangs");
        }

        for (Stu stu : stus) {
            System.out.println(stu);
        }
    }

    static class Stu{
        private Integer id;
        private String name;


        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Stu{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
