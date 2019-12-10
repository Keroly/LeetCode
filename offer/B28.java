/*
    二叉树的深度
题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

import java.util.Stack;

public class B28 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static int deep = 0;
    static Stack<Integer> stack = new Stack<>();

    public static void process(TreeNode root) {
        if (root == null){
            deep = deep > stack.size() ? deep : stack.size();
            return ;
        }
        stack.push(root.val);
        process(root.left);
        process(root.right);
        stack.pop();
    }

    public static int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        process(root);
        return deep;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        System.out.println(TreeDepth(root1));
    }
}
