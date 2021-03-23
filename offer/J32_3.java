/*
    从上到下打印二叉树

题目描述：
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class J32_3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<List<Integer>>();
        }

        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        list.add(root);
        int flag = 0;

        while (!list.isEmpty()) {
            int size = list.size();
            if (flag % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = list.poll();
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                    res.add(node.val);
                }
            }else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = list.pollLast();
                    if (node.right != null) {
                        list.addFirst(node.right);
                    }
                    if (node.left != null) {
                        list.addFirst(node.left);
                    }
                    res.add(node.val);
                }
            }
            ans.add(new LinkedList<>(res));
            res.clear();
            flag++;
        }
        return ans;
    }
}
