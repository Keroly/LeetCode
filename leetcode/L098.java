/*
    验证二叉搜索树

题目描述：
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

 */

import java.util.LinkedList;

public class L098 {
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//-----------------------------------------------  递归  ----------------------------------------------------------------

    public boolean isValidBST(TreeNode root) {
       return process(root, null, null);
    }

    public boolean process(TreeNode node, Integer lower, Integer upper){
        if (node == null) return true;
        if (lower != null && node.val <= lower) return false;
        if (upper != null && node.val >= upper) return false;
        return process(node.left, lower, node.val) && process(node.right, node.val, upper);
    }

//-----------------------------------------------  非递归  -------------------------------------------------------------

    public boolean isValidBST_2(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> lower = new LinkedList<>();
        LinkedList<Integer> upper = new LinkedList<>();
        list.push(root);
        lower.add(null);
        upper.add(null);
        while (!list.isEmpty()){
            TreeNode node = list.poll();
            Integer low = lower.poll();
            Integer up = upper.poll();

            if ((low != null && node.val <= low) || (up != null && node.val >= up)){
                return false;
            }

            if (node.left != null){
                list.add(node.left);
                lower.add(low);
                upper.add(node.val);
            }

            if (node.right != null){
                list.add(node.right);
                lower.add(node.val);
                upper.add(up);
            }

        }
        return true;
    }

//----------------------------------------------------  中序遍历  -------------------------------------------------------

}
