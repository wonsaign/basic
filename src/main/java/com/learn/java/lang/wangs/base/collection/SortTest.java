package com.learn.java.lang.wangs.base.collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    public static void main(String[] args) {
        List<Integer> is = Lists.newArrayList(1, 2, 3, 5, 2, 2, 45);

        is.sort(Comparator.comparingInt(e -> e));

        is.stream().map(null);

        //is.add
    }
}
