/*
    重建二叉树(n)

题目描述：
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 */

public class J07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode dfs(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj) {
        if (prei > prej){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prei]);
        int flag = ini;
        for (int i = ini; i <= inj; i++) {
            if (preorder[prei] == inorder[i]) {
                flag = i;
                break;
            }
        }
        root.left = dfs(preorder, prei + 1, prei + flag - ini, inorder, ini, flag - 1);
        root.right = dfs(preorder, prei + flag - ini + 1, prej, inorder, flag + 1, inj);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
