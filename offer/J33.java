/*
    二叉搜索树的后序遍历序列

题目描述：
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

 */

public class J33 {
    public boolean process(int[] postorder, int i, int j){
        if (i >= j) {
            return true;
        }
        int low = i;
        int high = j;
        int mid = i - 1;
        for (int w = j - 1; w >= i; w--) {
            if (postorder[w] <  postorder[j]){
                mid = w;
                break;
            }
        }
        for (int w = mid; w >= i; w--){
            if (postorder[w] > postorder[j]){
                return false;
            }
        }
        return process(postorder, i, mid) && process(postorder, mid + 1, j - 1);
    }

    public boolean verifyPostorder(int[] postorder) {
        return process(postorder, 0, postorder.length - 1);
    }
}
