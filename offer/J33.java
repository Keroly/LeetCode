/*
    二叉搜索树的后序遍历序列

题目描述：
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

 */

public class J33 {
    public boolean dfs(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int flag = postorder[right];
        int temp = right;
        for (int i = left; i < right; i++) {
            if (postorder[i] > postorder[right]) {
                temp = i;
                break;
            }
        }
        for (int i = temp; i < right; i++) {
            if (postorder[i] < postorder[right]) {
                return false;
            }
        }
        return dfs(postorder, left, temp - 1) && dfs(postorder, temp, right - 1);
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return dfs(postorder, 0, postorder.length - 1);
    }
}
