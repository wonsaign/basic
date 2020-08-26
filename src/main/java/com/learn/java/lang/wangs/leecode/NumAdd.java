package com.learn.java.lang.wangs.leecode;

import java.util.Collections;

public class NumAdd {


    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 11, 15};

        int target = 9;

        int[] twoSum = twoSum(nums, target);
        for (int i = 0; i < twoSum.length; i++) {
            System.out.println(twoSum[i]);
        }


    }


    public static int[] twoSum(int[] nums, int target) {
        // 先排序会不会更快呢
        for (int i = 0; i < nums.length; i++) {
            int ii = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int jj = nums[j];
                if (ii + jj == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
