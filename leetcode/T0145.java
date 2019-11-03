/*
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T0145 {
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null){
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                if(node.left != null){
                    stack.push(node.right);
                }
                if(node.right != null){
                    stack.push(node.left);
                }
            }
        }
        Stack<Integer> stack_1 = new Stack<Integer>();
        for (int i = 0; i < list.size(); i++){
            stack_1.push(list.get(i));
        }
        list.clear();
        while (!stack_1.isEmpty()){
            list.add(stack_1.pop());
        }
        return list;
    }
}
