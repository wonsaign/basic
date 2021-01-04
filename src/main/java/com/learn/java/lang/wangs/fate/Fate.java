package com.learn.java.lang.wangs.fate;

import java.util.Random;

/**
 * @author wangsai
 */
public class Fate {

    /**
     * 103,36 兰州
     * 108,34 西安
     * 126,45 哈尔滨
     * @param args
     */
    public static void main(String[] args) {
        // 垂直13，水平9

        Random r = new Random();
        int x = r.nextInt(13);
        int y = r.nextInt(9);

        System.out.println(x + "-----" + y);

        // 110, 41
        // 107, 37
        // 114, 35
    }
}
