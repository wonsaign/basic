package com.learn.java.lang.wangs.leecode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class ReverseTree {

    public static void main(String[] args) {
        //Integer[] data = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        Integer[] data = new Integer[]{7, 4, 9, 2, 5, 8, 11};

        BinarySearchTree<Object> tree = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            tree.add(data[i]);
        }

        System.out.println("init data end");

        frontForceach(tree.element);

        System.out.println("ReverseTree end");
    }

    /**
     * 前序遍历
     * 根节点，左节点，右节点
     *
     * 使用任何一种树的遍历方式都可以，然后遍历的时候，左右节点交换即可。
     */

    public static void frontForceach(Node element){
        if(element == null){
            return;
        }
        Node temp = element.left;
        element.left = element.right;
        element.right = temp;

        System.out.println("node = " + element.val);
        if(element.left != null){
            frontForceach(element.left);
        }
        if(element.right != null){
            frontForceach(element.right);
        }
    }
}
