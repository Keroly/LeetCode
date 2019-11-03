/*
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T0144 {
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null){
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
        return list;
    }
}
