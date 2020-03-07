/*
    二叉树中和为某一值的路径
题目描述
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class B25 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void proess(TreeNode root, int target, int cur){
        if (root == null && target == cur){     // 到达空节点，并且数值相等,形成list
            result.add(new ArrayList<>(stack));
        }

        if (root == null){  // 到达空节点，数值不等，出栈
            return;
        }

        stack.push(root.val);
        proess(root.left, target, cur + root.val);
        if (root.left != null || root.right != null) {
            proess(root.right, target, cur + root.val);
        }
        stack.pop();
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root != null){
            proess(root, target, 0);
        }

        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size() < o2.size()){
                    return 1;
                }else return -1;
            }
        });
        return result;
    }
}
