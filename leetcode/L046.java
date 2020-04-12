/*
    全排列

题目描述：
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */

import java.util.*;

public class L046 {
    public void process(ArrayList<Integer> nums, int length, int index, List<List<Integer>> result){
        if (index == length){
            result.add(new ArrayList<>(nums));
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < length; i++){
            if (!set.contains(nums.get(i))){
                set.add(nums.get(i));
                Collections.swap(nums, index, i);
                process(nums, length, index + 1, result);
                Collections.swap(nums, index, i);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        ArrayList<Integer> elements = new ArrayList<Integer>();
        for (Integer element: nums) {
            elements.add(element);
        }
        process(elements, nums.length, 0, result);

        return result;
    }
}
