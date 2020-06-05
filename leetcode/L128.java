/*
    最长连续序列

题目描述:
给定一个未排序的整数数组，找出最长连续序列的长度。 O(n)

 */


import java.util.HashSet;

public class L128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int result = 0;

        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i] - 1)){  // 找到连续子序列的最小位置
                int cur = nums[i];
                int count = 1;
                while (set.contains(cur + 1)){
                    cur += 1;
                    count += 1;
                }
                result = Math.max(result, count);
            }
        }

        return result;
    }

}
