package com.learn.java.lang.wangs.leecode;

/**
 * @author wangsai
 */

public class BinarySearchTree<E> {

    Node<E> root;
    Node<E> element;
    int size;

    public void add(E e){
        if(element == null){
            element = new Node(null, e);
            root = element;
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
            c = node.compare(e);
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


}
