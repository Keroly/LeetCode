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
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                result.add(stack.peek().val);
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return result;
    }
}
