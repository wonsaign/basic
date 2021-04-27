package com.learn.java.lang.wangs.base.collection;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        Set<String> s1 = Sets.newHashSet("a","b","c");
        Set<String> s2 = Sets.newHashSet("d","e","f","c","a");

        Sets.SetView<String> intersection = Sets.intersection(s1, s2);

        intersection.forEach(System.out::print);
        System.out.println("-------");
        s1.forEach(System.out::print);
        System.out.println("-------");
        s2.forEach(System.out::print);
    }
}
