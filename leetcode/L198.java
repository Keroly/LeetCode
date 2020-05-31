/*
    打家劫舍

题目描述：
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

 */

public class L198 {
    public int rob(int[] nums) {
        if (nums.length == 0)
        {
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = nums[0];
        for (int i = 2; i <= n; i++)
        {
            f[i] = Math.max(f[i - 1],f[i - 2] + nums[i - 1]);
        }
        return f[n];
    }
}
