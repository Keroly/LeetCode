/*
    第K个排列

题目描述：
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：
给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
 */

public class L060 {
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        return recursive(n, factorial(n - 1), k, visited);
    }

    private String recursive(int n, int f, int k, boolean[]visited){
        int offset = k % f;
        int groupIndex = k / f + (offset > 0 ? 1 : 0);  // 若第 0 组,取第一个未访问

        // 在没有被访问的数字里找第 groupIndex个数字
        int i = 0;
        for(; i < visited.length && groupIndex > 0; i++){
            if(!visited[i]){
                groupIndex--;
            }
        }

        visited[i-1] = true;// 标记为已访问
        if(n - 1 > 0){
            // offset = 0 时，则取第 i 组的第 f 个排列，否则取第 i 组的第 offset 个排列
            return String.valueOf(i) + recursive(n-1, f/(n - 1), offset == 0 ? f : offset, visited);
        }else{
            // 最后一数字
            return String.valueOf(i);
        }
    }

    private int factorial(int n){
        int res = 1;
        for(int i = n; i > 1; i--){
            res *= i;
        }
        return res;
    }

}
