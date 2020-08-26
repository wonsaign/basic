package com.learn.java.lang.wangs.meeting;

import java.util.List;

public class CodingTest {



    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        //int[] a = new int[]{1,1};
        System.out.println(calculateMaxArea(a));

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        //int[] nums = new int[]{0,0,1};
        int lenth = removeDuplicates(nums);
        System.out.println(lenth);


        //String[] strs = new String[]{"flower","flow","flight"};
        String[] strs = new String[]{""};

        System.out.println(longestCommonPrefix(strs));
    }



    public static int calculateMaxArea(int[] height){
        //int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        //int[] a = new int[]{1,1};
        // 思路是这样的
        // 从木桶的最高点开始切，切到一个面积，记录一个面积
        // 首先找到最大的那个数字，， 排序
        int maxNum = 0;
        for (int i = 0 ; i < height.length; i++) {
            if(height[i] > maxNum){
                maxNum = height[i];
            }
        }
        int maxArea = 0;
        int postionBegin = 0;
        int postionEnd = 0;
        for (int i = maxNum; i > 0; i--) {
            for (int j = 0; j < height.length; j++) {
                if(height[j] >= i){
                    if(postionBegin <= 0){
                        postionBegin = j + 1;
                    }else {
                        postionEnd = j + 1;
                    }
                }
            }
            if(maxArea < i * (postionEnd - postionBegin)){
                maxArea = i * (postionEnd - postionBegin);
            }
            postionBegin = 0;
            postionEnd = 0;
        }

        return maxArea;
    }

    public static int removeDuplicates(int[] nums) {
        // nums = [0,0,1,1,1,2,2,3,3,4]
        // 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
        // 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

        int position = 1;
        for (int i = 0; i < nums.length; i++) {
            if(i + 1 < nums.length && nums[i] < nums[i + 1]){
                nums[position] = nums[i + 1];
                position++;
            }
        }

        return position;
    }


    // 编写一个函数来查找字符串数组中的最长公共前缀。
    // 如果不存在公共前缀，返回空字符串 ""
    // 输入: ["flower","flow","flight"]
    // 输出: "fl"
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int maxLenth = 0;
        for (int i = 0; i < strs.length; i++) {
            if(maxLenth < strs[i].length()){
                maxLenth = strs[i].length();
            }
        }

        char[][] commonPre = new char[maxLenth][2];

        loop1:
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] bytes = s.toCharArray();
            for (int j = 0; j < bytes.length; j++) {
                if(commonPre[j][0] == 0){
                    commonPre[j][0] = bytes[j];
                }else if(commonPre[j][0] == bytes[j]){
                    commonPre[j][1]++;
                    continue;
                }else {
                    continue loop1;
                }
            }
        }
        String str = "";
        for (int i = 0; i < commonPre.length; i++) {
            if(commonPre[i][1] == strs.length - 1){
                str += commonPre[i][0];
            }
        }
        return str;
    }


    // 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
    // 注意：答案中不可以包含重复的三元组。
    public static List<List<Integer>> threeSum(int[] nums) {
        // nums = [-1, 0, 1, 2, -1, -4];

        return null;
    }
}
