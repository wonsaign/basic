package com.learn.java.lang.wangs.meeting;

public class GuomeiTest {

    public static void main(String[] args) {
        String s = "ab bc aaaa aaa";
        String s1 = "ab";
        String s2 = "a";
        String s3 = " ";
        String s4 = " ab";
        String s5 = " ab bcd";
        String s6 = " ab bcd d";
        String s7 = "ab bcd";
        String s8 = "ab bcd ";
        System.out.println(getLen(s));
        System.out.println(getLen(s1));
        System.out.println(getLen(s2));
        System.out.println(getLen(s3));
        System.out.println(getLen(s4));
        System.out.println(getLen(s5));
        System.out.println(getLen(s6));
        System.out.println(getLen(s7));
        System.out.println(getLen(s8));
    }

    private static int getLen(String s){
        if(s == null || "".equalsIgnoreCase(s)){
            return 0;
        }
        byte[] s_bytes = s.getBytes();

        int maxlen = 0;
        int templen = 0;
        for (int i = 0; i < s_bytes.length; i++) {
            if(s_bytes[i] == 32) {
                if (templen >= maxlen) {
                    maxlen = templen;
                }
                templen = 0;
                continue;
            }
            templen++;
        }
        if(maxlen == 0 || templen >= maxlen){
            maxlen = templen;
        }
        return maxlen;
    }
}
