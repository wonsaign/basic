package com.learn.java.lang.wangs.leecode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * @author wangsai
 */
public class BinarySearchTreeForeach {

    public static void main(String[] args) {
        //Integer[] data = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        Integer[] data = new Integer[]{7, 4, 9, 2, 5, 8, 11};

        BinarySearchTree<Object> tree = new BinarySearchTree<>();
        for (Integer datum : data) {
            tree.add(datum);
        }

        System.out.println("init data end");

        //frontForceach(tree.element);
        middleForceach(tree.element, false);
        System.out.println();
        middleForceach(tree.element, true);
        //behindForceach(tree.element);
        Queue<Node<Object>> queue = new LinkedList<>();
        levelForceach(tree.element, queue,
                node -> System.out.println("node = " + node.val));

        System.out.println(isCompleteBinTree(tree.element));
    }

    /**
     * 前序遍历
     * 根节点，左节点，右节点
     */

    public static void frontForceach(Node<Object> element){
        if(element == null){
            return;
        }
        System.out.println("node = " + element.val);
        if(element.left != null){
            frontForceach(element.left);
        }
        if(element.right != null){
            frontForceach(element.right);
        }
    }

    /**
     * 中序遍历
     * 左节点，根节点, 右节点
     * 遍历的结果就是有序的
     */

    public static void middleForceach(Node<Object> element, boolean positiveSequence){
        if(element == null){
            return;
        }
        if(positiveSequence){
            if(element.left != null){
                middleForceach(element.left, true);
            }
            System.out.print("node = " + element.val + ",");
            if(element.right != null){
                middleForceach(element.right, true);
            }
        }else {
            if(element.right != null){
                middleForceach(element.right, false);
            }
            System.out.print("node = " + element.val + ",");
            if(element.left != null){
                middleForceach(element.left, false);
            }
        }
    }

    public static Node<Object> findPre(Node<Object> node){
        // 存在于左节点的右边，就是node.left.right.right...
        if(node == null){
            return null;
        }
        node = node.left;
        while (node != null){
            if(node.right == null){
                return node;
            }
            node = node.right;
        }
        return null;
    }

    public static Node<Object> findNext(Node<Object> node){
        // 存在于左节点的右边，就是node.left.right.right...
        if(node == null){
            return null;
        }
        node = node.right;
        while (node != null){
            if(node.left == null){
                return node;
            }
            node = node.left;
        }
        return null;
    }

    /**
     * 后序遍历
     * 左节点，右节点，根节点
     */

    public static void behindForceach(Node<Object> element){
        if(element == null){
            return;
        }
        if(element.left != null){
            behindForceach(element.left);
        }
        if(element.right != null){
            behindForceach(element.right);
        }
        System.out.println("node = " + element.val);
    }


    /**
     * 层序遍历
     * 一层一层的遍历
     * 思路，使用队列，每次根节点访问的时候，都将左右节点加入队列，然后根节出队，继续进行。相同的步骤
     * 应用，可以判断 树高 ， 判断是不是完全二叉树
     */
    public static void levelForceach(Node<Object> element, Queue<Node<Object>> queue, Consumer<Node<Object>> c){
        if(element == null){
            return;
        }
        // Queue<BinarySearchTree.Node> queue = new LinkedList<>();
        Node<Object> e = element;
        while (e != null){
            if(e.left != null){
                queue.offer(e.left);
            }
            if(e.right != null){
                queue.offer(e.right);
            }
            c.accept(e);
            e = queue.poll();
        }
    }

    /**
     * 判断是不是完全二叉树
     * @return
     */
    public static boolean isCompleteBinTree(Node<Object> node){
        Queue<Node<Object>> queue = new LinkedList<>();

        /**
         * left != null && rigth != null 入队
         * left == null && right != null false
         * (left == null && right == null) || (left != null && right == null) 那么后续所有的节点都必须是叶子节点
         */
        Node<Object> e = node;
        while (e != null){
            if(e.left != null && e.right != null){
                queue.offer(e.left);
                queue.offer(e.right);
                e = queue.poll();
            }else if(e.left == null && e.right != null){
                return false;
            // 剩余4种情况的另外两种
            }else {
                Node<Object> poll = queue.poll();
                assert poll != null;
                return poll.left == null && poll.right == null;
            }
        }

        return false;
    }
}
