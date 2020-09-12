package com.learn.java.lang.wangs.leecode;

/**
 * @author wangsai
 */

public class BinarySearchTree<E> {

    Node<E> element;
    int size;

    public void add(E e){
        if(element == null){
            element = new Node(null, e);
            size++;
            return;
        }
        // 从根节点开始往下查找
        Node<E> node = element;
        // 这个父节点，只是用于下面关联左右自节点
        Node<E> parentNode = element;
        int c = 0;
        while (node != null){
            // 所以这个比较器可以自定义实现，这样就可以反转树
            c =  compare(node.val, e);
            parentNode = node;
            if(c > 0){
                node = node.right;
            }else if(c < 0){
                node = node.left;
            }else{
                return;
            }
        }
        // 现在要挂载节点,需要parent
        Node newNode = new Node(parentNode, e);
        if(c < 0){
            parentNode.left = newNode;
        }else {
            parentNode.right = newNode;
        }
        size++;
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        BinarySearchTree<Object> tree = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            tree.add(data[i]);
        }

        System.out.println("end");
    }

    private int compare(E e1, E e2){
        // TODO:
        if(e1 instanceof Integer && e2 instanceof Integer){
           return (Integer)e2 - (Integer)e1;
        }
        return 0;
    }

    static class Node<E>{
        E val;
        Node<E> left;
        Node<E> right;
        Node<E> parent;// parent 好像不是必须的
        public Node(Node<E> parent, E e){
            val = e;
            this.parent = parent;
        }
    }
}
