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

    /**
     * 当前节点，是父节点的左子树
     * @return
     */
    public boolean isLeftChild(){
        return parent != null && this == parent.left;
    }

    /**
     * 当前节点，是父节点的右子树
     * @return
     */
    public boolean isRightChild(){
        return parent != null && this == parent.right;
    }
}
