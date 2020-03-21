/*
    两数之和
题目描述：
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
*/

import java.util.HashMap;
import java.util.Map;

public class L001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) return result;
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
