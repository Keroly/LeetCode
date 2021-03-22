/*
    从上到下打印二叉树

题目描述：
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class J32_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int lens = list.size();
            for (int i = 0; i < lens; i++) {
                TreeNode node = list.poll();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                ans.add(node.val);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
