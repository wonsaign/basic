package com.learn.java.lang.wangs;

public class LajiJava {

    public static void main(String[] args) {
        String str = "abcdefg";
        // str[2:5]
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if(i > 2 && i < 6){
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());

        int[] is = new int[3];
    }
}
