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
        LinkedList<TreeNode>  linkedList = new LinkedList<TreeNode>();
        if (root == null) {
            return res;
        }
        linkedList.add(root);
        while (linkedList.size() > 0) {
            int size = linkedList.size();
            List<Integer>  arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.pollFirst();
                arrayList.add(node.val);
                if (node.left != null) {
                    linkedList.add(node.left);
                }
                if (node.right != null) {
                    linkedList.add(node.right);
                }
            }
            res.add(arrayList);
        }
        return res;
    }
}
