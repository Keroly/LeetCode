/*
    零钱兑换

题目描述：
给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。

你可以假设：
0 <= amount (总金额) <= 5000
1 <= coin (硬币面额) <= 5000
硬币种类不超过 500 种
结果符合 32 位符号整数

 */

public class L518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++)
        {
            for (int j = coins[i - 1]; j <= amount; j++)
            {
                dp[j] = dp[j] + dp[j - coins[i - 1]] ;
            }
        }
        return dp[amount];
    }
}
