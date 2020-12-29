package com.learn.java.lang.wangs.leecode;

import com.learn.java.lang.wangs.leecode.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * @author wangsai
 */

public class BinarySearchTree<E> implements BinaryTreeInfo {

    Node<E> root;
    Node<E> element;
    int size;

    public void add(E e){
        if(element == null){
            element = createNode(null, e);
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
        //Node newNode = new Node(parentNode, e);
        Node newNode = createNode(parentNode, e);
        if(c < 0){
            parentNode.left = newNode;
        }else {
            parentNode.right = newNode;
        }
        size++;


        afferAdd(newNode);
    }

    // 模版替换
    protected Node<E> createNode(Node<E> parent, E e){
        return new Node(null, e);
    }

    protected void afferAdd(Node<E> e) {
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
        size--;
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
        Node node = root;
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

    /**
     * 前序遍历
     * 根节点，左节点，右节点
     */

    public void frontForceach(Node<E> element){
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

    public void middleForceach(Node<E> element, boolean positiveSequence){
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

    public Node<E> findPre(Node<E> node){
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

    /**
     * 后序遍历
     * 左节点，右节点，根节点
     */

    public void behindForceach(Node<E> element){
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
    public void levelForceach(Node<E> element, Queue<Node<E>> queue, Consumer<Node<E>> c){
        if(element == null){
            return;
        }
        // Queue<BinarySearchTree.Node> queue = new LinkedList<>();
        Node<E> e = element;
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
    public boolean isCompleteBinTree(Node<E> node){
        Queue<Node<E>> queue = new LinkedList<>();

        /**
         * left != null && rigth != null 入队
         * left == null && right != null false
         * (left == null && right == null) || (left != null && right == null) 那么后续所有的节点都必须是叶子节点
         */
        Node<E> e = node;
        while (e != null){
            if(e.left != null && e.right != null){
                queue.offer(e.left);
                queue.offer(e.right);
                e = queue.poll();
            }else if(e.left == null && e.right != null){
                return false;
                // 剩余4种情况的另外两种
            }else {
                Node<E> poll = queue.poll();
                assert poll != null;
                return poll.left == null && poll.right == null;
            }
        }

        return false;
    }


    /**
     * 前序遍历
     * 根节点，左节点，右节点
     *
     * 使用任何一种树的遍历方式都可以，然后遍历的时候，左右节点交换即可。
     */

    public void reverseTree(Node<E> element){
        if(element == null){
            return;
        }
        Node temp = element.left;
        element.left = element.right;
        element.right = temp;

        System.out.println("node = " + element.val);
        if(element.left != null){
            reverseTree(element.left);
        }
        if(element.right != null){
            reverseTree(element.right);
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).val;
    }
}
