/*
    二叉树的镜像

题目描述：
操作给定的二叉树，将其变换为源二叉树的镜像。

 */

public class J27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = mirrorTree(right);
        root.right = mirrorTree(left);
        return root;
        
    }
}
