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
        if (prei > prej || ini > inj) return null;
        TreeNode head = new TreeNode(preorder[prei]);
        int mid = -1;
        for (int i = ini; i <= inj; i++){
            if (inorder[i] == preorder[prei]){
                mid = i;
                break;
            }
        }

        head.left = process(preorder,prei + 1, prei + mid - ini, inorder, ini, mid - 1);
        head.right = process(preorder,prei + mid - ini + 1 , prej, inorder, mid + 1, inj);
        return head;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder ==null || preorder.length == 0 || inorder.length == 0) return null;
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
