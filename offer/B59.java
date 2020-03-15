/*
    按之字型打印二叉树
题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

import java.util.ArrayList;
import java.util.Stack;

public class B59 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode node = null;
        if (pRoot == null) return result;
        stack1.push(pRoot);
        int index = 1;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if ((index & 1) == 1){
                while (!stack1.isEmpty()){
                    node = stack1.pop();
                    list.add(node.val);
                    if (node.left != null){
                        stack2.push(node.left);
                    }
                    if (node.right != null){
                        stack2.push(node.right);
                    }
                }
            }else {
                while (!stack2.isEmpty()){
                    node = stack2.pop();
                    list.add(node.val);
                    if (node.right != null){
                        stack1.push(node.right);
                    }
                    if (node.left != null){
                        stack1.push(node.left);
                    }
                }
            }
            result.add(new ArrayList<Integer>(list));
            list.clear();
            index++;
        }
        return result;
    }
}
