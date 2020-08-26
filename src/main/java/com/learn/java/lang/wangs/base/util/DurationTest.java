package com.learn.java.lang.wangs.base.util;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationTest {

    public static void main(String[] args) {
        LocalDateTime b = LocalDateTime.of(2020, 1, 2, 00, 00, 00);
        LocalDateTime e = LocalDateTime.of(2020, 1, 3, 20, 47, 00);

        Duration between = Duration.between(b, e);

        System.err.println(between.toHours());
        System.err.println(between.toMinutes());
        System.out.println(between.toMinutes() / 60 + "~~~~~~~" + between.toMinutes() % 60);
        //System.err.println(between.toSeconds());
    }
}
