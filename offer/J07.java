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

    public TreeNode process(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj){
        if (prei > prej  || ini > inj){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prei]);
        int index = 0;
        for (int i = ini; i <= inj; i++){
            if (inorder[i] == preorder[prei]){
                index = i;
                break;
            }
        }
        root.left = process(preorder, prei + 1, prei + index - ini, inorder, ini, index - 1);
        root.right = process(preorder, prei + index - ini + 1, prej, inorder, index + 1, inj);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
