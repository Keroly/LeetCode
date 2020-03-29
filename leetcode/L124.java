/*
    二叉树的最大路径和

题目描述:
给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */

public class L124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int result = Integer.MIN_VALUE;

    public int process(TreeNode root) {
        if (root == null) return 0;
        int left = process(root.left);
        int right = process(root.right);
        int sum = Math.max(Math.max(left + right + root.val, root.val), Math.max(left + root.val, right + root.val));
        result = Math.max(result, sum);
        return Math.max(root.val , Math.max(left + root.val, right + root.val)); // 比较结点、结点+左、结点+右
    }

    public int maxPathSum(TreeNode root) {
        process(root);
        return result;
    }
}