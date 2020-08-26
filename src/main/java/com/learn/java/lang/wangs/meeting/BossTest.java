package com.learn.java.lang.wangs.meeting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BossTest {


    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3};
        int[] array2 = new int[]{2,5,6};
        int[] retainAll = retainAll(array1, array2);
        if(retainAll != null){
            for (int i = 0; i < retainAll.length; i++) {
                System.out.println(retainAll[i]);
            }
        }

        char[] c1 = new char[]{'a','b','c','d','e','f','g'};
        char[] c2 = new char[]{'a','b','c','d','f','g'};

        System.out.println(find(c1, c2));

        int[] array ={1,2,3,4,6,7,8,9,10};
        System.out.println( binSearch(3,array,0,array.length-1));
        System.out.println( binSearch(5,array,0,array.length-1));
        System.out.println( binFind(c1,c2,0,c1.length-1));
    }



    public static char find(char[] chars1, char[] chars2){
        if(chars1 == null || chars2 == null){
            throw new RuntimeException("请保证两个数组不为空");
        }
        int l1 =  chars1.length;
        int l2 =  chars2.length;

        for (int i = 0; i < (l1 > l2 ? l2 : l1); i++) {
            char c1 = chars1[i];
            char c2 = chars2[i];
            if(c1 != c2){
                // 返回长度长的那个
                if(l1 > l2){
                    return chars1[i];
                }else {
                    return chars2[i];
                }
            }
        }
        throw new RuntimeException("两个数组完全一样");
    }

    public static int[] retainAll(int[] array1, int[] array2){
        // XXX: 不知道规则如何判定, 我暂且认为 空 和 非空， 则返回非空
        if(array1 == null && array1 == null){
            return null;
        }
        if(array1 == null){
            return array2;
        }
        if(array2 == null){
            return array1;
        }
        int al1 = array1.length;
        int al2 = array2.length;

        List<Integer> resultList = new ArrayList<>();
        // 方法一: 最为原始  双层嵌套循环  时间复杂度 0（平方）
        for (int i = 0; i < array1.length; i++) {
            int a1 = array1[i];
            for (int j = 0; j < array2.length; j++) {
                int a2 = array2[j];
                if(a1 == a2){
                    //result[head] = a2;
                    //head++;
                    resultList.add(a2);
                    break;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        // 方法二: 使用hashset 时间复杂度 0（2n）
        for (int i = 0; i < array1.length; i++) {
            set.add(array1[i]);
        }
        for (int j = 0; j < array2.length; j++) {
            if(set.contains(array2[j])){
                resultList.add(array2[j]);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }


    /*
     *递归实现二分算法
     */
    public static int binSearch(int key,int[] array,int low,int high){
        //防越界
        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }
        int middle = (low+high)/2;
        if(array[middle]>key){
            //大于关键字
            return  binSearch(key,array,low,middle-1);
        }else if(array[middle]<key){
            //小于关键字
            return binSearch(key,array,middle+1,high);
        }else{
            return array[middle];
        }
    }


    // char[] c1 = new char[]{'a','b','c','d','e','f','g'};
    // char[] c2 = new char[]{'a','b','c','d','f','g'};
    public static char binFind(char[] chars1, char[] chars2, int low, int high){
        if(low > chars1.length || low > chars2.length || high - low == 0){
            // 返回长度长的那个
            if(chars1.length > chars2.length){
                return chars1[low];
            }else {
                return chars2[low];
            }
        }
        int middle = (low+high) >> 1;
        if(chars1[middle] == chars2[middle]){
            // 在右边的
            return binFind(chars1, chars2,middle+1, high);
        }else {
            // 在左边
            return binFind(chars1, chars2, low,middle-1);
        }
    }
}
