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
        int target = postorder[right];
        int flag = right - 1;
        for (int i = left; i < right; i++) {
            if (postorder[i] > target) {
                flag = i - 1;
                break;
            }
        }
        for (int i = flag + 1; i < right; i++) {
            if (postorder[i] < target) {
                return false;
            }
        }
        return dfs(postorder, left, flag) && dfs(postorder, flag + 1, right - 1);
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return dfs(postorder, 0, postorder.length - 1);
    }
}
