/*
    从上到下打印二叉树

题目描述：
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class J32_3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int flag = 1;
        s1.add(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            if (flag % 2 == 1) {
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        s2.push(node.left);
                    }
                    if (node.right != null) {
                        s2.push(node.right);
                    }
                }
            }else {
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        s1.push(node.right);
                    }
                    if (node.left != null) {
                        s1.push(node.left);
                    }
                }
            }
            res.add(list);
            flag++;
        }
        return res;
    }
}
