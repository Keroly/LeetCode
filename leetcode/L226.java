/*
    翻转二叉树

题目描述：
翻转一棵二叉树。
 */

public class L226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode new_left = invertTree(root.right);
        TreeNode new_right = invertTree(root.left);

        root.left = new_left;
        root.right = new_right;

        return root;
    }
}
