/*
    从上到下打印二叉树

题目描述：
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class J32_2 {
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
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        int size = 1;
        while (size > 0){
            List<Integer> list = new ArrayList<>();
            for (int i = size; i > 0; i--){
                TreeNode node = linkedList.poll();
                list.add(node.val);
                if (node.left != null){
                    linkedList.add(node.left);
                }
                if (node.right != null){
                    linkedList.add(node.right);
                }
            }
            size = linkedList.size();
            res.add(list);
        }
        return res;
    }
}
