package com.learn.java.lang.wangs.leecode;

public class Leecode_287 {


    public static void main(String[] args) {
        int[] n = {1,3,4,2,2};
        int[] n2 = {3,1,3,4,2};

        System.out.println("n = " + findDuplicate(n2));
    }

    public static int findDuplicate(int[] nums) {

        int lenth = nums.length;

        int fastTemp = 0;
        int slowTemp = 0;
        for(;;){
            if(fastTemp != slowTemp && nums[fastTemp] == nums[slowTemp]){
                return nums[slowTemp];
            }
            slowTemp++;
            fastTemp+=3;
            // [2,4,1,3,0] [2,4,1,3,0]
            if(fastTemp >= lenth){
                fastTemp = lenth - (lenth * 2 - fastTemp - 1) - 1;
            }
            // [0,1,2,3,4]
            if(slowTemp >= lenth){
                slowTemp = lenth - (lenth * 2 - slowTemp - 1) - 1;
            }
        }
    }
}
