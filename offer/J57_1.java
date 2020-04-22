/*
    和为s的两个数字(n)

题目描述：
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可

 */

public class J57_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2){
            return result;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            if (nums[i] + nums[j] < target){
                i++;
            }else if (nums[i] + nums[j] > target){
                j--;
            }else {
                result[0] = nums[i];
                result[1] = nums[j];
                break;
            }
        }
        return result;
    }
}
