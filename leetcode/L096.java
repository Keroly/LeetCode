/*
    不同的二叉搜索树

题目描述：
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

 */

public class L096 {
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int k = 2; k < n + 1; k++){
            int count = 0;
            for (int i = 0, j = k - 1; j >= 0; i++, j--){
                count += result[i] * result[j];
            }
            result[k] = count;
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(new L096().numTrees(3));
    }
}
