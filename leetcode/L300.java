/*
    最长上升子序列(n^2)

题目描述：
给定一个无序的整数数组，找到其中最长上升子序列的长度。

说明:
可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。你算法的时间复杂度应该为 O(n2) 。

进阶:
你能将算法的时间复杂度降低到 O(n log n) 吗?

 */

public class L300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i ++)
        {
            dp[i] = 1;
            for (int j = 1; j < i; j++)
            {
                if (nums[j - 1] < nums[i - 1])
                {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int res = 0;
        for (Integer element : dp)
        {
            res = Math.max(res, element);
        }
        return res;
    }
}
