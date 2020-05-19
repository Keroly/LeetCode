/*
    从上到下打印二叉树

题目描述：
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 */

import java.util.ArrayList;
import java.util.LinkedList;

public class J32_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        linkedList.addLast(root);
        while(!linkedList.isEmpty()){
            TreeNode node = linkedList.pollFirst();
            arrayList.add(node.val);
            if (node.left != null){
                linkedList.addLast(node.left);
            }
            if (node.right != null){
                linkedList.addLast(node.right);
            }
        }
        int size = arrayList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++){
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
