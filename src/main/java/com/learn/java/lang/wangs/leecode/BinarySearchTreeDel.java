package com.learn.java.lang.wangs.leecode;

/**
 * @author wangsai
 */

public class BinarySearchTreeDel<E> {

    // Node<E> node;

    BinarySearchTree<Object> tree;


    public static void main(String[] args) {
        BinarySearchTreeDel delTree = new BinarySearchTreeDel();

        Integer[] data = new Integer[]{7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        BinarySearchTree<Object> tree = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            tree.add(data[i]);
        }

        System.out.println("end");

        delTree.tree = tree;

        delTree.del(7);

        System.out.println("delEd");
    }


    public void del(E element){
        Node<E> delNode = findByElement(element);

        // 度2 删除方式
        if(delNode.left != null && delNode.right != null){
            Node<E> next = findNext(delNode);
            delNode.val = next.val;
            // 将node节点指向要被删除的那个节点
            // 一定要理解，这里的赋值语句，并没有修改原来节点引用关系
            // 脑海里一定要有指向关系，变量指向了地址的关系图，delNode = next，
            // 只是delNode重新赋值，并没有修改什么，并不是原来的节点指向next节点
            delNode = next;
        }
        delLeaf(delNode);
        delOneSide(delNode);
    }

    // 删除叶子节点
    private void delLeaf(Node<E> delNode){
        if(delNode.parent.right == delNode){
            delNode.parent.right = null;
        }else {
            delNode.parent.left = null;
        }
    }
    // 删除只有一个度的
    private void delOneSide(Node<E> delNode){
        if(delNode.left != null && delNode.right == null){
            if(delNode.parent.right == delNode){
                delNode.parent.right = delNode.left;
            }else {
                delNode.parent.left = delNode.left;
            }
        }else if(delNode.right != null && delNode.left == null) {
            if (delNode.parent.right == delNode) {
                delNode.parent.right = delNode.right;
            } else {
                delNode.parent.left = delNode.right;
            }
        }
    }

    public Node<E> findNext(Node<E> node){
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

    private Node<E> findByElement(E element){
        Node node = tree.root;
        while (node != null){
            int compare = node.compare(element);
            if(compare == 0){
                return node;
            }else if(compare > 0){
                node = node.right;
            }else {
                node = node.left;
            }
        }
        return null;
    }
}
