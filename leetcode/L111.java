/*
    二叉树的最小深度

题目描述：
求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 */

import java.util.LinkedList;

public class L111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int run(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int level = 1;
        while (list.size() != 0){
            for (int i = list.size(); i > 0; i--){
                TreeNode node = list.pop();
                if (node.left != null){
                    list.add(node.left);
                }
                if (node.right != null){
                    list.add(node.right);
                }
                if (node.left == null && node.right == null){
                    return level;
                }
            }
            level++;
        }
        return 0;
    }
}
