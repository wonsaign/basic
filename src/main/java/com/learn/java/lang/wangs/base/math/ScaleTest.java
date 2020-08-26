package com.learn.java.lang.wangs.base.math;

/**
 * 进制算法
 *
 * @author wangsai
 */
public class ScaleTest {


    public static void main(String[] args) {
//        fiveScale(123);
//        fiveScaleToTen(443);
        fiveScale(6);
        fiveScaleToTen(11);
    }

    /**
     * 10进制转5进制
     *
     * @author wangsai
     * @date 2020年2月4日 下午2:55:31
     */
    public static void fiveScale(int i) {
        // 25 转换为5进制是 200?
        // 5转10,5的零幂数*数字+5的1一次幂数*数字
        // 6 = 11 7=12  ... 26 = 101
        // 应该是26/5+26%5 = 6 
        String s = "";
        int yushu = 0;
        do {
            yushu = i % 5;
            i = i / 5;
            s = String.valueOf(yushu) + s;
        } while (i >= 5);

        // 补位处理
        if (i > 5 && i == 0) {
            s = "1" + s;
        } else {
            s = String.valueOf(i) + s;
        }
        System.err.println(Integer.valueOf(s));
    }

    public static void fiveScaleToTen(int num) {
        String s = String.valueOf(num);
        int scale = 5;
        char[] charArray = s.toCharArray();
        int total = 0;
        // 443 = 4*5*5 + 4*5 + 3
        for (int i = charArray.length - 1; i >= 0; i--) {
            int mup = 1;
            for (int j = i; j > 0; j--) {
                if (j != 0) {
                    mup *= scale;
                }
            }

            int sx = Integer.valueOf(String.valueOf(charArray[charArray.length - i - 1]));
            total = total + mup * sx;
        }
        System.err.println(total);
    }
}
