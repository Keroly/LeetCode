/*
    从上往下打印二叉树
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B19 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return list;
    }
}