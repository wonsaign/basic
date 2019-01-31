package com.learn.java.lang.wangs.util.guava;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import org.checkerframework.checker.nullness.qual.Nullable;

public class GuavaTest {

    public static void main(String[] args) {

    }

    private static void Collections2() {
        Maps.asMap(Sets.newHashSet(), (Function<Integer, String>) (@Nullable Integer input) -> "hi");
    }
}