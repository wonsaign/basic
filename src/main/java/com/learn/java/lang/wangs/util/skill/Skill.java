package com.learn.java.lang.wangs.util.skill;

public class Skill {

    public static void main(String[] args) {

    }

    // 使用查询表代替复杂的表达式
    @SuppressWarnings("unused")
    private static void selectTableInsteadOfExpress() {
        String month = "";
        int day = 0;
        // if("1,3,5,7,8,10,12".equals(month)){
        //     day = 31;
        // }
        // if("4,6,9,11".equals(month)){
        //     day = 30;
        // }
        // if("28".equals(month)){
        //     day = 28;
        // }
        // 使用下标代替当前月份,可以代替大量循环
        int[] tableNormalMonthDay = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] tableRunMonthDay = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }
}