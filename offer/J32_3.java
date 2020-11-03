/*
    从上到下打印二叉树

题目描述：
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 */

import java.util.ArrayList;
import java.util.LinkedList;
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

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        int flag = 1;

        while (linkedList.size() > 0) {
            List<Integer> list = new LinkedList<Integer>();
            int size = linkedList.size();
            if (flag % 2 == 0) {
                while (size-- > 0) {
                    TreeNode node = linkedList.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        linkedList.addFirst(node.right);
                    }
                    if (node.left != null) {
                        linkedList.addFirst(node.left);
                    }
                }
            }else {
                while (size-- > 0) {
                    TreeNode node = linkedList.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        linkedList.addLast(node.left);
                    }
                    if (node.right != null) {
                        linkedList.addLast(node.right);
                    }
                }
            }
            res.add(list);
            flag++;
        }
        return res;
    }
}
