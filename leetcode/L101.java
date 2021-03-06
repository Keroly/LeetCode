/*
    对称二叉树

题目描述：
给定一个二叉树，检查它是否是镜像对称的。    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 */

import java.util.LinkedList;

public class L101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//----------------------------------------------  递归  -----------------------------------------------------------------

    public boolean process(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return process(left.left, right.right) && process(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return process(root.left, root.right);
    }

//----------------------------------------------  非递归  ---------------------------------------------------------------

    public boolean isSymmetric_2(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode left = list.poll();
            TreeNode right = list.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            list.add(left.left);
            list.add(right.right);
            list.add(left.right);
            list.add(right.left);
        }
        return true;
    }
}
