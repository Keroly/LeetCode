/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T0094 {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode head;
        head = root;
        while(head != null || !stack.isEmpty()){
            if (head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                list.add(head.val);
                head = head.right;
            }
        }
        return list;
    }
}
