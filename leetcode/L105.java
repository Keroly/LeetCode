/*
    从前序与中序遍历序列构造二叉树

题目描述：
根据一棵树的前序遍历与中序遍历构造二叉树。

 */
public class L105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode process(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj){
        if (prei > prej || ini > inj) {
            return null;
        }

        int index = 0;
        for (int i = ini; i <= inj; i++) {
            if (inorder[i] == preorder[prei]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[prei]);
        root.left = process(preorder, prei + 1, prei + index - ini, inorder, ini, index - 1);
        root.right = process(preorder, prei + index - ini + 1, prej, inorder, index + 1, inj);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
