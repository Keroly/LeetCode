/*
    序列化二叉树

题目描述：
请实现两个函数，分别用来序列化和反序列化二叉树

二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

 */

import java.util.LinkedList;

public class J37 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder str = new StringBuilder("[");
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            if (node != null) {
                str.append(node.val + ",");
                list.add(node.left);
                list.add(node.right);
            }else {
                str.append("null,");
            }
        }
        str.deleteCharAt(str.length() - 1);
        str.append("]");
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        int i = 0;
        String[] str = data.substring(1, data.length() - 1).split(",");
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[i++]));
        list.add(root);
        while(!list.isEmpty()) {
            TreeNode node = list.poll();
            if (!str[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(str[i]));
                list.add(node.left);
            }
            i++;
            if (!str[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(str[i]));
                list.add(node.right);
            }
            i++;
        }
        return root;
    }
}
