/*
    全排列

题目描述：
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

 */

import java.util.*;

public class L046 {

    List<List<Integer>> res;
    List<Integer> ans;
    int[] flag;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<List<Integer>>();
        ans = new LinkedList<>();
        flag = new int[nums.length];
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int index) {
        if (index == nums.length) {
            res.add(new LinkedList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                ans.add(nums[i]);
                dfs(nums, index + 1);
                ans.remove(ans.size() - 1);
                flag[i] = 0;
            }
        }
    }

}
