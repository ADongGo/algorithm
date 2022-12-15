package com.adong.base.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author beiting
 * @Description TreeOrderForeach
 * @Date 2022-12-07 7:54 PM
 */
public class TreeOrderForeach {

    public List<Integer> preOrder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop().right;
            }
        }
        return list;
    }

    public List<Integer> inOrder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

    public List<Integer> postOrder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if(node.right == null || node.right == pre) {
                    list.add(node.val);
                    stack.pop();
                    pre = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return list;
    }
}
