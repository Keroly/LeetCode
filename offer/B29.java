/*
    平衡二叉树
题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class B29 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static boolean flag = true;

    public static int process(TreeNode root) {
        if (root == null) return 1;
        int left = process(root.left);
        int right = process(root.right);
        if (Math.abs(left - right) > 1) flag = false;
        return right > left ? right + 1: left + 1;
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        process(root);
        return flag;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        System.out.println(IsBalanced_Solution(root1));
    }
}
