/*
    数组中出现次数超过一半的数(n)

题目描述:
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 */

public class J39 {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans || flag == 0) {
                ans = nums[i];
                flag += 1;
            }else {
                flag -= 1;
            }
        }
        return ans;
    }
}
