/*
    三角形最小路径和

题目描述：
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 空间复杂度O(n)（n 为三角形的总行数）

 */

import java.util.List;

public class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++)
        {
            dp[i + 1] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 1; i >= 1; i--)
        {
            for (int j = 1; j <= i; j++)
            {
                dp[j] = Math.min(dp[j],dp[j + 1]) + triangle.get(i - 1).get(j - 1);
            }
        }
        return dp[1];
    }
}
