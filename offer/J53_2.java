/*
    寻找0 ~ n-1中缺失的数字

题目描述:
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

 */

public class J53_2 {
    public int search(int[] nums, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if (nums[mid] == mid && nums[mid + 1] != mid + 1){
            return mid + 1;
        }
        if (nums[mid] == mid){
            return search(nums, mid + 1, end);
        }
        if (nums[mid] == mid + 1){
            return search(nums,  start, mid - 1);
        }
        return -1;
    }
    public int missingNumber(int[] nums) {
        if (nums[0] == 1){
            return 0;
        }
        if (nums[nums.length - 1] == nums.length - 1){
            return nums.length;
        }
        return search(nums, 0, nums.length - 1);
    }
}
