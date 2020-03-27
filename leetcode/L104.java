/*
    二叉树的最大深度

题目描述：
给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
 */

import java.util.LinkedList;

public class L104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//----------------------------------------------  非递归  ---------------------------------------------------------------
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root == null) return 0;
        list.add(root);
        int level = 0;
        while (!list.isEmpty()){
            level ++;
            int count = list.size();

            while (count-- > 0){
                TreeNode node = list.pop();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null){
                    list.add(node.right);
                }
            }
        }
        return level;
    }
//-----------------------------------------------  递归  ---------------------------------------------------------------
    public int maxDepth_2(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int result = Math.max(left, right) + 1;
        return result;
    }
}
