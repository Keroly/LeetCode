/*
    最大子序和(n)

题目描述：
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

 */

public class L053 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int  last = 0;
        for (int i = 0; i < nums.length; i++) {
            int now = Math.max(last, 0) + nums[i];
            res = Math.max(res, now);
            last = now;
        }
        return res;
    }
}
