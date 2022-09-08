package com.adong.base.tree;

/**
 * @author beiting
 * @Description Solution98 验证二叉搜索树
 * @Date 2022-09-08 6:49 PM
 */
public class Solution98 {

    public boolean isValidBST(TreeNode root) {

        return rec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean rec(TreeNode node, long min, long max) {
        if (node == null) return true;
        if(node.val <= min || node.val >= max) return false;
        return rec(node.left, min, node.val) && rec(node.right, node.val, max);
    }

    public static void main(String[] args) {

    }
}
