package com.adong.base.tree;

/**
 * @author adong
 * @Description Solution105
 * @Date 2022-09-07 12:19 AM
 */
public class Solution105 {

    public static void main(String[] args) {
        Solution105 solution = new Solution105();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        solution.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return rec(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * preOrder: [3,9,20,15,7]
     * 父节点      ^
     * inOrder:  [9,3,15,20,7]
     * 父节点        ^
     */
    private TreeNode rec(int[] preorder, int pLeft, int pRight,
                         int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight || iLeft > iRight) return null;
        int root = preorder[pLeft];
        int index = 0;
        // 找到父节点
        for (int i = iLeft; i <= iRight; i++) {
            if(inorder[i] == root) {
                index = i;
                break;
            }
        }
        int leftSize = index - iLeft;
        TreeNode node = new TreeNode(root);
        node.left = rec(preorder, pLeft + 1, pLeft + leftSize,
                inorder, iLeft, index - 1);
        node.right = rec(preorder, pLeft + leftSize + 1, pRight,
                inorder, index + 1, iRight);
        return node;
    }
}
