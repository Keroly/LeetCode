/*
    对称的二叉树
题目描述
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class B58 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean process(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return process(left.left, right.right) && process(left.right, right.left);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return false;
        return process(pRoot.left, pRoot.right);
    }
}
