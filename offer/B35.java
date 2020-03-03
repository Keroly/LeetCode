/*
    二叉搜索树和双向链表
题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class B35 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static TreeNode node;

    public static void process(TreeNode root){
        if (root == null) return;
        if (root.left != null){
            process(root.left);
        }
        root.left = node;
        if (node != null){
            node.right = root;
        }
        node = root;
        if (root.right != null){
            process(root.right);
        }
    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        process(pRootOfTree);
        while (node != null && node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(6);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(12);

        Convert(root1);
        while (node != null){
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
}
