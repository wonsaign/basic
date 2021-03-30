package com.learn.java.lang.wangs.leecode.days;

/**
 * s0: abc
 * s1: abc cab
 * s2: abccab babcca
 * s3: abccab babcca aabccab babcc
 *
 *
 * 问 2的13次方后+1
 *
 * 内存容易冒
 * @author wangsai
 */
public class StringTest {

    public char getChar(String s0, long times){
        StringBuilder sb0 = new StringBuilder(s0);
        while (times > 0){
            char[] chars = new char[sb0.length()];
            sb0.getChars(0, sb0.length(), chars, 0);
            sb0.append(chars[chars.length - 1]).append(chars);
            sb0.deleteCharAt(sb0.length() - 1);
            times--;
        }
        //System.out.println(sb0);
        System.out.println(sb0.charAt(sb0.length() - 1));
        return sb0.charAt(sb0.length() - 1);
    }

    public char getChar2(String s0, long times){
        char[] chars0 = s0.toCharArray();
        long l = times % chars0.length;

        System.out.println(chars0[chars0.length - 1 - (int)l]);
        return chars0[chars0.length - 1 - (int)l];
    }

    public static void main(String[] args) {
        StringTest st = new StringTest();
        //st.getChar("abc", 9999999999999999L);
        st.getChar2("abc", 9999999999999999L);
    }
}
