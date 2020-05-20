/*
    连续子数组的最大和(n)

题目描述：
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

 */

public class J42 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] <= nums[i]){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
