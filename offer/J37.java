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
            return "";
        }
        String str = "";
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                if (node == null) {
                    str += "#,";
                }else {
                    str += node.val +",";
                    list.add(node.left);
                    list.add(node.right);
                }
            }
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")){
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        String[] str = data.split(",");
        TreeNode res = new TreeNode(Integer.parseInt(str[0]));
        list.add(res);
        int index = 1;
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            if (!str[index].equals("#")){
                node.left = new TreeNode(Integer.parseInt(str[index]));
                list.add(node.left);
            }
            index++;
            if (!str[index].equals("#")){
                node.right = new TreeNode(Integer.parseInt(str[index]));
                list.add(node.right);
            }
            index++;
        }
        return res;
    }
}
