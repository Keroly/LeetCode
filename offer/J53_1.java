/*
    在排序数组中查找数字出现的次数

题目描述：
统计一个数字在排序数组中出现的次数

 */

public class J53_1 {
    public int searchLower(int[] nums, int target, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if (nums[mid] < target){
            return searchLower(nums, target, mid + 1, end);
        }
        if (nums[mid] > target){
            return searchLower(nums, target, start, mid - 1);
        }
        if ( mid == 0 || nums[mid] != nums[mid - 1]){
            return mid;
        }else{
            return searchLower(nums, target, start, mid - 1);
        }
    }

    public int searchUpper(int[] nums, int target, int start, int end){
        if (start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if (nums[mid] < target){
            return searchUpper(nums, target, mid + 1, end);
        }
        if (nums[mid] > target){
            return searchUpper(nums, target, start, mid - 1);
        }
        if ( mid == nums.length - 1 || nums[mid] != nums[mid + 1]){
            return mid;
        }else{
            return searchUpper(nums, target, mid + 1, end);
        }
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int start = searchLower(nums, target, 0, nums.length - 1);
        int end = searchUpper(nums, target, 0, nums.length - 1);

        if (start == -1){
            return 0;
        }

        return end - start + 1;
    }
}
