/*
    对称二叉树
题目描述：
给定一个二叉树，检查它是否是镜像对称的。    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */

import java.util.LinkedList;

public class L101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//----------------------------------------------  递归  -----------------------------------------------------------------

    public boolean process(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val == node2.val){
            return process(node1.left, node2.right) && process(node1.right, node2.left) ;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return process(root.left, root.right);
    }

//----------------------------------------------  非递归  ---------------------------------------------------------------

    public boolean isSymmetric_2(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        list.add(root);
        while (!list.isEmpty()){
            TreeNode node1 = list.pop();
            TreeNode node2 = list.pop();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            list.add(node1.left);
            list.add(node2.right);
            list.add(node1.right);
            list.add(node2.left);
        }
        return true;
    }

}
