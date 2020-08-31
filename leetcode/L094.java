/*
    二叉树的中序遍历

题目描述：
使用非递归,进行二叉树的中序遍历。

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L094 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
}
