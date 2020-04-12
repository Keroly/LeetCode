/*
    全排列2

题目描述：
给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class L047 {
    public void process(ArrayList<Integer> nums, int length, int index, List<List<Integer>> result){
        if (index == length){
            result.add(new ArrayList<>(nums));
            return;
        }
        HashSet<Integer> set = new HashSet<>();


        for (int i = index; i < length; i++){
            if ( !set.contains(nums.get(i))){
                set.add(nums.get(i));
                Collections.swap(nums, index, i);
                process(nums, length, index + 1, result);
                Collections.swap(nums, index, i);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
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
