/*
    二叉树的后序遍历

题目描述：
使用非递归,进行二叉树的后序遍历。

 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L145 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<Integer> s2 = new Stack<Integer>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node.val);
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop());
        }
        return res;
    }
}
