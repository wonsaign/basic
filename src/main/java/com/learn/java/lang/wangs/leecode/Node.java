package com.learn.java.lang.wangs.leecode;

/**
 * @author wangsai
 */
public class Node<E> {

    E val;
    Node<E> left;
    Node<E> right;
    Node<E> parent;
    public Node(Node<E> parent, E e){
        val = e;
        this.parent = parent;
    }

    public int compare(E e2){
        // TODO:
        if(this.val instanceof Integer && e2 instanceof Integer){
            return (Integer)e2 - (Integer)this.val;
        }
        return 0;
    }
}
