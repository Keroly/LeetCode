/*
    从上到下打印二叉树

题目描述：
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class J32_3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack_1 = new Stack();
        Stack<TreeNode> stack_2 = new Stack();
        stack_1.add(root);
        int flag = 1;
        while (!stack_1.isEmpty() || !stack_2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if (flag % 2 == 1){
                while (!stack_1.isEmpty()) {
                    TreeNode node = stack_1.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        stack_2.add(node.left);
                    }
                    if(node.right != null) {
                        stack_2.add(node.right);
                    }
                }
            }else {
                while (!stack_2.isEmpty()) {
                    TreeNode node = stack_2.pop();
                    list.add(node.val);
                    if(node.right != null) {
                        stack_1.add(node.right);
                    }
                    if (node.left != null) {
                        stack_1.add(node.left);
                    }
                }
            }
            res.add(list);
            flag++;
        }
        return res;
    }
}
