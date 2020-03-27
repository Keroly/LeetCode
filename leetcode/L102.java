/*
    二叉树的的层次遍历

题目描述：
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        list.add(root);
        int level = -1;
        while (!list.isEmpty()){
            level ++;
            int count = list.size();
            result.add(new ArrayList<>());

            while (count-- > 0){
                TreeNode node = list.pop();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null){
                    list.add(node.right);
                }
                result.get(level).add(node.val);
            }
        }
        return result;
    }
}
