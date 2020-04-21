/*
    二叉搜索树的第k大结点

题目描述：
给定一棵二叉搜索树，请找出其中第k大的节点

 */

import java.util.Stack;

public class J54 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        int count = k;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur  !=  null){
            if  (cur != null){
                stack.add(cur);
                cur = cur.right;
            }else {
                TreeNode node = stack.pop();
                if (--count == 0){
                    return node.val;
                }
                cur = node.left;
            }
        }
        return root.val;
    }
}
