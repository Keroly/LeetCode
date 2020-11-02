/*
    调整数组顺序使奇数位于偶数前面(n)

题目描述：
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 */

public class J21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }else {
                left++;
            }
        }
        return nums;
    }
}
