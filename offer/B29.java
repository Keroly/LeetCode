/*
    平衡二叉树
题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class B29 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean flag = true;

    public int process(TreeNode root){
        if (root == null) return 0;
        int left = process(root.left);
        int right = process(root.right);
        if (Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left, right) + 1;

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        process(root);
        return flag;
    }

}
