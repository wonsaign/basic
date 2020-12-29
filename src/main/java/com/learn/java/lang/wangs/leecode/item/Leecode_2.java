package com.learn.java.lang.wangs.leecode.item;

import com.learn.java.lang.wangs.leecode.struct.ListNode;

public class Leecode_2 {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *      输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *      输出：7 -> 0 -> 8
     *      原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     *
     * 24316 -> 61342
     * 132 ->   23100 / 100
     * @param l1
     * @param l2
     * @return
     */

    public static void main(String[] args) {
//        ListNode l1_0 = new ListNode(2);
//        ListNode l1_1 = new ListNode(4);
//        ListNode l1_2 = new ListNode(3);
//        ListNode l1_3 = new ListNode(1);
//        ListNode l1_4 = new ListNode(6);
//        l1_0.next = l1_1;
//        l1_1.next = l1_2;
//        l1_2.next = l1_3;
//        l1_3.next = l1_4;
//
//        ListNode l2_0 = new ListNode(1);
//        ListNode l2_1 = new ListNode(3);
//        ListNode l2_2 = new ListNode(2);
//        l2_0.next = l2_1;
//        l2_1.next = l2_2;

        ListNode l1_0 = new ListNode(9);

        ListNode l2_0 = new ListNode(1);
        ListNode l2_1 = new ListNode(9);
        ListNode l2_2 = new ListNode(9);
        ListNode l2_3 = new ListNode(9);
        ListNode l2_4 = new ListNode(9);
        ListNode l2_5 = new ListNode(9);
        ListNode l2_6 = new ListNode(9);
        ListNode l2_7 = new ListNode(9);
        ListNode l2_8 = new ListNode(9);
        ListNode l2_9 = new ListNode(9);
        l2_0.next = l2_1;
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l2_4;
        l2_4.next = l2_5;
        l2_5.next = l2_6;
        l2_6.next = l2_7;
        l2_7.next = l2_8;
        l2_8.next = l2_9;

        Leecode_2 answer = new Leecode_2();

        ListNode listNode = answer.addTwoNumbers(l1_0, l2_0);

        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 分析
         * 方式1 倒叙【乘以10】
         * 方式2 对其后后补零后移位
         *
         * 本次选择方式二
         */
        long l1int = 0;
        long l2int = 0;
        long bits1 = 0;
        long bits2 = 0;
        while (l1 != null || l2 != null){
            if(l1 != null ){
                int temp = 1;
                long tempbit = bits1;
                while (tempbit > 0){
                    temp = temp * 10;
                    tempbit--;
                }
                // 10的指数
                l1int = l1int + l1.val * temp;
                l1 = l1.next;
                bits1++;
            }else {
               l1int = l1int * 10;
            }
            if(l2 != null ){
                int temp = 1;
                long tempbit = bits2;
                while (tempbit > 0){
                    temp = temp * 10;
                    tempbit--;
                }
                l2int = l2int + l2.val * temp;
                l2 = l2.next;
                bits2++;
            }else {
                l2int = l2int * 10;
            }

        }
        while (l1int >= 10 && l1int % 10 == 0){
            l1int = l1int / 10;
        }
        while (l2int >= 10 && l2int % 10 == 0){
            l2int = l2int / 10;
        }
        if(l1int == l2int && l1int == 0){
            return new ListNode(0);
        }
        // 61573
        long sum = l1int + l2int;
        ListNode next = null;
        ListNode head = null;
        while (sum > 0 && sum != sum / 10){
            long bit = sum % 10;
            sum = sum / 10;
            ListNode node = new ListNode((int)bit);
            if(next == null){
                next = node;
                head = next;
            }else {
                next.next = node;
                next = node;
            }
        }

        return head;
    }
}