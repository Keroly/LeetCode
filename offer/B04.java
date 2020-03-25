/*
    重建二叉树

题目描述：
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class B04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode process(int [] pre, int prei, int prej, int [] in, int ini, int inj){
        if (pre == null || in == null || prei > prej || ini > inj) return null;
        TreeNode head = new TreeNode(pre[prei]);
        int tag = -1;
        for (int i = ini; i <= inj; i++){
            if (in[i] == pre[prei]){
                tag = i;
                break;
            }
        }
        head.left = process(pre, prei + 1, prei + tag - ini, in, ini, tag - 1);
        head.right = process(pre, prei + tag - ini + 1, prej, in, tag + 1, inj);
        return head;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        return process(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
}

//  时间：O(n)