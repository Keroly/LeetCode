/*
    重建二叉树
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
import java.util.Stack;

public class B04 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode process(int prei, int prej, int ini, int inj, int [] pre,int [] in){
        if (ini > inj){
            return null;
        }
        for (int i = ini; i <= inj; i++){
            if (pre[prei] == in[i]){
                TreeNode node = new TreeNode(pre[prei]);
                node.left = process(prei + 1, prei + i - ini, ini, i - 1, pre, in);
                node.right = process(prei + i - ini + 1, prej, i + 1, inj, pre, in);
                return node;
            }
        }
        return null;
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        return process(0, pre.length - 1, 0, in.length - 1, pre, in);
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre, in);

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> stack_2 = new Stack<TreeNode>();

        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            stack_2.push(top);
            if (top.left != null){
                stack.push(top.left);
            }
            if (top.right != null){
                stack.push(top.right);
            }
        }

        while (!stack_2.isEmpty()){
            System.out.print(stack_2.pop().val + " ");  // 7 4 2 5 8 6 3 1
        }
    }
}
