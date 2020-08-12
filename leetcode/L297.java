/*
    二叉树的序列化与反序列化

题目描述：
    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"

 */

import java.util.LinkedList;

public class L297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String res = root.val + ","+ serialize(root.left) + "," + serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        String[] str = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (String s: str) {
            list.add(s);
        }
        return dfs(list);
    }

    public TreeNode dfs(LinkedList<String> list){
        if (list.peek().equals("#")) {
            list.poll();
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.poll()));
        root.left = dfs(list);
        root.right = dfs(list);
        return root;
    }
}
