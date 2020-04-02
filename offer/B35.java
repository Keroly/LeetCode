/*
    二叉搜索树和双向链表

题目描述：
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

import java.util.Stack;

public class B35 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode result = null;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.add(cur);
                cur = cur.left;
            }else {
                TreeNode node = stack.pop();
                if (result == null){
                    result = node;
                }
                if (pre != null){
                    pre.right = node;
                }
                node.left = pre;
                pre = node;
                cur = node.right;
            }
        }
        return result;
    }
}
