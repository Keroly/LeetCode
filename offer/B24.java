/*
    二叉搜索树的后序遍历序列

题目描述：
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

public class B24 {
    public boolean process(int [] sequence, int i, int j){
        if (i >= j) return true;

        int flag = i;

        while (flag < j){
            if (sequence[flag] > sequence[j]) {
                break;
            }
            flag += 1;
        }

        int tag = flag;

        while (flag < j){
            if (sequence[flag] < sequence[j]){
                return false;
            }
            flag += 1;
        }

        return process(sequence, i, flag - 1) && process(sequence, flag, j - 1);

    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return process(sequence, 0, sequence.length - 1);
    }

}
