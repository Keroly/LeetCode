/*
    平衡二叉树(n)

题目描述：
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

 */

public class J55_2 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int process(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = process(root.left);
        if (left == -1){
            return  -1;
        }

        int right = process(root.right);
        if (right == -1){
            return  -1;
        }

        if (Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        int isBalancedTree = process(root);
        if(isBalancedTree < 0){
            return false;
        }
        return true;
    }
}
