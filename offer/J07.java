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

    public TreeNode process(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj) {
        if (prei > prej) {
            return null;
        }
        TreeNode ans = new TreeNode(preorder[prei]);
        int flag = ini;
        for (int i = ini; i <= inj; i++) {
            if (inorder[i] == preorder[prei]) {
                flag = i;
                break;
            }
        }
        ans.left = process(preorder, prei + 1, prei + flag - ini, inorder, ini, flag - 1);
        ans.right = process(preorder, prei + flag - ini + 1, prej, inorder, flag + 1, inj);
        return ans;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }
}
