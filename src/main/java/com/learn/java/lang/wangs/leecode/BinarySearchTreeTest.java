package com.learn.java.lang.wangs.leecode;

import com.learn.java.lang.wangs.leecode.printer.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeTest {

    private static BinarySearchTree<Object> tree;

    public static void main(String[] args) {
        delTest();
    }

    private static void addTest(){
        Integer[] data = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        tree = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            tree.add(data[i]);
        }
        BinaryTrees.print(tree);
        System.out.println();
    }

    private static void delTest(){
        addTest();
        tree.del(7);
        System.out.println("---------------------");
        BinaryTrees.print(tree);
    }

    private static void foreachTest(){

        addTest();

        tree.frontForceach(tree.element);
        tree.middleForceach(tree.element, false);
        // System.out.println();
        tree.middleForceach(tree.element, true);
        //behindForceach(tree.element);
        Queue<Node<Object>> queue = new LinkedList<>();
        tree.levelForceach(tree.element, queue,
                node -> System.out.println("node = " + node.val));

        System.out.println(tree.isCompleteBinTree(tree.element));
    }
}
