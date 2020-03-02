/*
    二叉搜索树的后序遍历序列
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class B24 {
    public static boolean process(int [] sequence, int i, int j){
        if (i >= j) return true;

        int x = i;

        for (;x < j; x++){
            if (sequence[x] > sequence[j]) break;
        }

        for (int y = x; y < j; y++){
            if (sequence[y] < sequence[j]) return false;
        }

        return process(sequence, i, x - 1) && process(sequence, x, j - 1);

    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return process(sequence, 0, sequence.length - 1);
    }

    public static void main(String[] args) {
        int[] sequence = {5,7,6,9,11,10,8};
        int[] sequence_1 = {5};
        int[] sequence_2 = {7,4,6,5};
        System.out.println(VerifySquenceOfBST(sequence));
        System.out.println(VerifySquenceOfBST(sequence_1));
        System.out.println(VerifySquenceOfBST(sequence_2));
    }
}
