/*
    二叉树的直径

题目描述：
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
两结点之间的路径长度是以它们之间边的数目表示。

 */

import java.util.ArrayList;
import java.util.LinkedList;

public class L543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int depth = 0;

    public int process(TreeNode root) {
        if (root == null) return 0;
        int left = process(root.left);
        int right = process(root.right);
        depth = Math.max(depth, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        process(root);
        return depth - 1;
    }
}
