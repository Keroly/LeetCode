/*
    二叉树的最近公共祖先

题目描述：
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */

import java.util.ArrayList;
import java.util.Stack;

public class L236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    ArrayList<TreeNode> p_list = new ArrayList<>();
    ArrayList<TreeNode> q_list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    public void process(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return;

        stack.push(root);

        if (root.val == p.val){
            p_list = new ArrayList<>(stack);
        }

        if (root.val == q.val){
            q_list = new ArrayList<>(stack);
        }

        process(root.left, p, q);
        process(root.right, p, q);

        stack.pop();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        process(root, p, q);
        int pre = -1;
        while (pre < p_list.size() - 1 &&  pre < q_list.size() - 1 && p_list.get(pre + 1) == q_list.get(pre + 1)){
            pre++;
        }
        return p_list.get(pre);
    }

}
