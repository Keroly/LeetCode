/*
    从上到下打印二叉树

题目描述：
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 */

import java.util.ArrayList;
import java.util.LinkedList;

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
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        list.add(root);
        while (list.size() > 0) {
            int lens = list.size();
            for (int i = 0; i < lens; i++) {
                TreeNode cur = list.pollFirst();
                res.add(cur.val);
                if (cur.left != null) {
                    list.addLast(cur.left);
                }
                if (cur.right != null) {
                    list.addLast(cur.right);
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
