/*
    二叉搜索树的第k个子节点
题目描述
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class B62 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 但也可以不使用递归
    int index = 1;
    TreeNode result = null;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return null;
        if (index <= k){
            KthNode(pRoot.left, k);
            if (index == k) result = pRoot;
            KthNode(pRoot.right, k);
            index++;
        }
        return result;
    }
}
