package com.learn.java.lang.wangs.leecode;

/**
 * 反转链表
 */
public class ReverseList  {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head) {
        ListNode newHead = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode reverseNode = reverseBetween(n1);

        for (int i = 0; i < 3; i++) {
            System.out.println("hi");
        }

    }
}
