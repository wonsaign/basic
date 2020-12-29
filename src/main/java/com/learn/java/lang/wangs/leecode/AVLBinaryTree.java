package com.learn.java.lang.wangs.leecode;


/**
 * @author wangsai
 */
public class AVLBinaryTree<E> extends BinarySearchTree<E>{


    // 树的添加是不动的，AVL树添加完成后，要进行平衡的
    @Override
    protected void afferAdd(Node<E> e) {
        if(e instanceof AVLNode){
            while ((e = e.parent) != null){
                if(((AVLNode)e).isBalanced()){
                    ((AVLNode)e).updateHeigth();
                }else{
                    rebalance(e);
                    break;
                }
            }
        }
    }

    public void rebalance(Node<E> grand){
        // LL，RR，LR，RL
        // 判断上面那几个情况，通过判断比较高的那个节点
        Node parent = ((AVLNode) grand).tallChild();
        Node node = ((AVLNode) parent).tallChild();

        // 记忆技巧，以及思考，LL是右单旋，LR，是先右再左(RL)，同理RR是左旋，RL是先左再右(LR)，
        // 旋转方向永远是与左右子树相反的方向。
        // 为啥呢，LL代表了左边不平衡了，所以要右旋，所以即同理
        if(parent.isLeftChild()){
            if(node.isLeftChild()){
                //LL 右旋
                rotateLeft(grand);
            }else {
                //LR
                rotateRight(grand);
                rotateLeft(parent);
            }
        }else {
            if(node.isLeftChild()){
                //RL
                rotateLeft(grand);
                rotateRight(parent);
            }else {
                //RR 左旋
                rotateRight(grand);
            }
        }

    }


    private void rotateLeft(Node<E> e){

    }

    private void rotateRight(Node<E> e){

    }

    @Override
    protected Node<E> createNode(Node<E> parent, E e) {
        return new AVLNode<>(parent, e);
    }
}
