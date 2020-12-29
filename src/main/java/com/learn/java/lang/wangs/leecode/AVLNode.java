package com.learn.java.lang.wangs.leecode;

public class AVLNode<E> extends Node<E>{

    int heigth = 1;

    public AVLNode(Node<E> parent, E e) {
        super(parent, e);
    }

    public int balanceFactor(){
        int left = this.left == null ? 0 : ((AVLNode)this.left).heigth;
        int right = this.right == null ? 0 : ((AVLNode)this.right).heigth;
        return left - right;
    }

    public void updateHeigth(){
        int left = this.left == null ? 0 : ((AVLNode)this.left).heigth;
        int right = this.right == null ? 0 : ((AVLNode)this.right).heigth;
        this.heigth = 1 + Math.max(left, right);
    }

    public Node<E> tallChild(){
        int left = this.left == null ? 0 : ((AVLNode)this.left).heigth;
        int right = this.right == null ? 0 : ((AVLNode)this.right).heigth;
        if(left > right){
            return this.left;
        }
        if(left < right){
            return this.right;
        }
        return isLeftChild() ? this.left : this.right;
    }

    /**
     * 平衡因子
     * @return
     */
    public boolean isBalanced(){
        return Math.abs(balanceFactor()) <= 1;
    }
}
