package com.learn.java.lang.wangs.leecode.item;

/**
 *
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2的31次方,  2的31次方 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 * 提示：
 * -231 <= x <= 231 - 1
 *
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 *
 * @author wangsai
 */
public class Leecode_7 {

    public int reverse(int x) {

        String s = String.valueOf(x);

        char[] chars = s.toCharArray();

        if(chars.length == 1){
            return x;
        }
        // 设置最后一个数字
        char[] nchars = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            nchars[chars.length - 1 - i] = chars[i];
        }
        while (nchars[0] == '0'){
            char[] temp = new char[nchars.length-1];
            System.arraycopy(nchars,1, temp, 0,nchars.length - 1);
            nchars = temp;
        }
        // 判断符号位置
        if(nchars[nchars.length - 1] == '-'){
            if(nchars.length == 2){
                return Integer.parseInt(String.valueOf(nchars[1]) + String.valueOf(nchars[0]));
            }
            // -120 -> 021-
            char[] temp = new char[nchars.length];
            System.arraycopy(nchars,0, temp, 1,nchars.length - 1);
            temp[0] = '-';
            nchars = temp;
        }

        try{
            return Integer.parseInt(String.valueOf(nchars));
        }catch (NumberFormatException e){
            return 0;
        }

    }


    public static void main(String[] args) {
        Leecode_7 l7 = new Leecode_7();
        // -120 -> 021-
//        System.out.println(l7.reverse(-123));
//        System.out.println(l7.reverse(0));
//        System.out.println(l7.reverse(120));
//        System.out.println(l7.reverse(10));
        //System.out.println(l7.reverse(-100));
        //System.out.println(l7.reverse(1534236469));
        System.out.println(l7.reverse(-901000));
    }
}
