/*
    重建二叉树
题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B04 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode process(int prei, int prej, int ini, int inj, int [] pre,int [] in){
        if(ini > inj){ // 当中序遍历数组中头部索引大于尾部索引结束本次递归
            return null;
        }
        for (int j = ini; j <= inj; j++) {
            if (in[j] == pre[prei]){
                TreeNode node = new TreeNode(pre[prei]); // pre[prei] 先序数组中的第一个
                node.left = process(prei + 1, prei + j - ini, ini, j - 1, pre, in);
                node.right = process(prei + j - ini + 1, prej,j + 1, inj, pre, in);
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

        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            list.add(top.val);
            if (top.right != null){
                stack.push(top.right);
            }
            if (top.left != null){
                stack.push(top.left);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
