package com.learn.java.lang.wangs.meeting;

public class GuomeiTest {

//    public static void main(String[] args) {
//        String s = "ab bc aaaa aaa";
//        String s1 = "ab";
//        String s2 = "a";
//        String s3 = " ";
//        String s4 = " ab";
//        String s5 = " ab bcd";
//        String s6 = " ab bcd d";
//        String s7 = "ab bcd";
//        String s8 = "ab bcd ";
//        System.out.println(getLen(s));
//        System.out.println(getLen(s1));
//        System.out.println(getLen(s2));
//        System.out.println(getLen(s3));
//        System.out.println(getLen(s4));
//        System.out.println(getLen(s5));
//        System.out.println(getLen(s6));
//        System.out.println(getLen(s7));
//        System.out.println(getLen(s8));
//    }

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

    /**
     * 两个有序数组 排序
     * 利用现在的排序信息，优化复杂度
     *
     */

    private static int[] combineSortList(int[] a,int[] b){

        int[] c = new int[a.length + b.length];

        int maxlen = a.length + b.length;

        int pointA = 0;
        int pointB = 0;
        for (int i = 0; i < maxlen; i++) {
            if(i == maxlen - 1){
                if(a[a.length - 1] > b[b.length - 1]){
                    c[i] = a[a.length - 1];
                }else {
                    c[i] = b[b.length - 1];
                }
                break;
            }
            if(a[pointA] <= b[pointB]){
                c[i] = a[pointA];
                if(pointA < a.length -1){
                    pointA++;
                }
            }else {
                c[i] = b[pointB];
                if(pointB < b.length -1){
                    pointB++;
                }
            }

        }
        return c;
    }


    private static int[] sortS(int[] a){
        a = new int[]{1, 1, 2, 2, 3, 4, 5};
        a = new int[]{1, 1, 2, 2, 2, 3, 4, 5};

        // int point = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if(i == j){
                    continue;
                }
                if(a[i] == a[j] && j + 1< a.length){
//                    if(a[j] == a[j+1]){
//
//                    }
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }


        return a;
    }




    public static void main(String[] args) {
//        int[] a1 = {1,3,4,9};
//        int[] a2 = {2,5,6};
//
//        int[] c = combineSortList(a1, a2);
//
//        for (int i = 0; i < c.length; i++) {
//            System.out.println(c[i]);
//        }
        int[] a = new int[]{1, 1, 2, 2, 2, 3, 4, 5};
        int[] c = sortS(a);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }
}
