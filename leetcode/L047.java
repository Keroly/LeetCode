/*
    全排列2

题目描述：
给定一个可包含重复数字的序列，返回所有不重复的全排列。

 */

import java.util.*;

public class L047 {

    List<List<Integer>> res;
    Integer[] ans;
    int[] flag;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new LinkedList<List<Integer>>();
        ans = new Integer[nums.length];
        flag = new int[nums.length];
        dfs (nums, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int index, int start) {
        if (index == nums.length) {
            List<Integer> list = Arrays.asList(ans);
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < flag.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                ans[i] = nums[index];
                dfs(nums, index + 1, index + 1 < nums.length && nums[index] == nums[index + 1] ? i + 1 : 0);
                flag[i] = 0;
            }
        }
    }
}
