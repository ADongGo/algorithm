package com.adong.base.tree;

/**
 * @author adong
 * @Description TreeOrder
 * @Date 2021-09-05 7:26 PM
 */
public class TreeOrder {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(Node node) {
        if(node == null) return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

}
