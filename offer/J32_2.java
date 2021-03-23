/*
    从上到下打印二叉树

题目描述：
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class J32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(root);
        while (!l1.isEmpty()) {
            int size = l1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = l1.poll();
                if (node.left != null) {
                    l1.add(node.left);
                }
                if (node.right != null) {
                    l1.add(node.right);
                }
                l2.add(node.val);
            }
            ans.add(new ArrayList<>(l2));
            l2.clear();
        }
        return ans;
    }
}
