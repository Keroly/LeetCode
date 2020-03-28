/*
    二叉树展开为链表

题目描述：
给定一个二叉树，原地将它展开为链表。

    1
   / \
  2   5             1-2-3-4-5-6
 / \   \
3   4   6
 */

import java.util.Stack;

public class L114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//------------------------------------------- 使用额外空间 ---------------------------------------------------------------
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode cur = new TreeNode(-1);
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            if (node.right != null){
                stack.add(node.right);
            }
            if (node.left != null){
                stack.add(node.left);
            }

            cur.right = node;
            cur.left = null;
            cur = node;
        }
    }
//------------------------------------------- 使用额外空间 ---------------------------------------------------------------
    TreeNode next = null;

    public void flatten_2(TreeNode root) {
        if (root == null) return;
        flatten_2(root.right);
        flatten_2(root.left);
        root.right = next;
        root.left = null;
        next = root;

    }
//------------------------------------------- 不使用额外空间 ------------------------------------------------------------
    public void flatten_3(TreeNode root) {
        if (root == null) return;
        while (root != null){
            TreeNode node = root.left;
            while (node != null && node.right != null){
                node = node.right;
            }

            if (node != null && node.right == null){
                node.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }

}
