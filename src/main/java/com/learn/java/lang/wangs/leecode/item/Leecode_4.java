package com.learn.java.lang.wangs.leecode.item;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 2^3 = 8  log2 8 = 3
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 *
 * @author wangsai
 */
public class Leecode_4 {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1 == 0 && l2 == 0){
            return 0.0;
        }
        if(l1 == 0){
            if(l2 % 2 ==0){
                return (double) (nums2[l2 / 2] + nums2[l2 / 2 - 1]) / 2;
            }else {
                return nums2[l2 / 2];
            }
        }
        if(l2 == 0){
            if(l1 % 2 ==0){
                return (double) (nums1[l1 / 2] + nums1[l1 / 2 - 1]) / 2;
            }else {
                return nums1[l1 / 2];
            }
        }

        int[] sum = new int[l1 + l2];

        int p1=0, p2=0;
        int m1, m2;
        for (int i = 0; i < sum.length; i++) {
            // 提前结束
            if(p1 + p2 > (sum.length / 2)){
                if(sum.length % 2 == 0){
                   return Double.valueOf(sum[p1 + p2 - 1] + sum[p1 + p2 - 2]) / 2;
                }else {
                    return sum[p1 + p2 - 1];
                }
            }
            if(p1 >= l1){
                m1 = nums1[p1 - 1];
                if(p2 < l2){
                    sum[p1 + p2] = nums2[p2];
                    p2++;
                    continue;
                }
            }else {
                m1 = nums1[p1];
            }
            if(p2 >= l2){
                m2 = nums2[p2 - 1];
                if(p1 < l1){
                    sum[p1 + p2] = nums1[p1];
                    p1++;
                    continue;
                }
            }else {
                m2 = nums2[p2];
            }
            if(m1 < m2 && p1 < l1){
                sum[p1 + p2] = nums1[p1];
                p1++;
            }
            if(m1 >= m2 && p2 < l2){
                sum[p1 + p2] = nums2[p2];
                p2++;
            }
        }
        if(p1 + p2 > (sum.length / 2)){
            if(sum.length % 2 == 0){
                return (double) (sum[p1 + p2 - 1] + sum[p1 + p2 - 2]) / 2;
            }else {
                return sum[p1 + p2 - 1];
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1,2} ;
//        int[] nums2 = {3,4};

        int[] nums1 = {1} ;
        int[] nums2 = {1};

        Leecode_4 l4 = new Leecode_4();
        System.out.println(l4.findMedianSortedArrays(nums1, nums2));
    }
}
