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
        String ans = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        String[] str = data.split(",");
        for (String element: str) {
            list.add(element);
        }
        TreeNode node = dfs(list);
        return node;
    }

    public TreeNode dfs(LinkedList<String> list){
        if (list.peek().equals("#")) {
            list.poll();
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.pop()));
        root.left = dfs(list);
        root.right = dfs(list);
        return root;
    }
}
