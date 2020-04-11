/*
    移动零

题目描述：
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */

public class L283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}
