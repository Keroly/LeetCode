/*
    数组中重复的数字(n)

题目描述：
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

 */

public class J03 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (i != nums[i] && nums[nums[i]] != nums[i]){
                int a = nums[i];
                int b = nums[a];
                nums[a] = a;
                nums[i] = b;
                i--;
                continue;
            }
            if (i != nums[i]){
                return nums[i];
            }
        }
        return -1;
    }
}
