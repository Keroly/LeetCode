/*
    数组中重复的数字(n)

题目描述：
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

 */

public class J03 {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i && nums[i] != nums[nums[i]]){
                swap(nums, nums[i], nums[nums[i]]);
                i--;
            }else if (nums[i] == i) {
                continue;
            }else if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
        }
        return -1;
    }
}
