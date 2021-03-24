/*
    二叉树中和为某一值的路径

题目描述：
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class J34 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        temp.add(root);
        res.add(root.val);
        dfs(ans, temp, res, root.val, sum);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, LinkedList<TreeNode> temp, LinkedList<Integer> res, int val, int sum) {
        TreeNode node = temp.peekLast();
        if (node.left == null && node.right == null && val == sum) {
            ans.add(new ArrayList<>(res));
        }

        if (node.left != null) {
            temp.add(node.left);
            res.add(node.left.val);
            dfs(ans, temp, res, val + node.left.val, sum);
            temp.pollLast();
            res.pollLast();
        }

        if (node.right != null) {
            temp.add(node.right);
            res.add(node.right.val);
            dfs(ans, temp, res, val + node.right.val, sum);
            temp.pollLast();
            res.pollLast();
        }
    }
}
