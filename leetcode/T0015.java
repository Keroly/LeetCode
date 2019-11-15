/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T0015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length < 3 || nums == null) return result;
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i -1]) continue;
            if(nums[i] > 0) break;
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                int temp = nums[L] + nums[R] + nums[i];
                if (temp == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }else {
                    if (temp > 0) R--;
                    if (temp < 0) L++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        List<List<Integer>> result = threeSum(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).get(0) + ",");
            System.out.print(result.get(i).get(1) + ",");
            System.out.print(result.get(i).get(2));
            System.out.println("");
        }
    }
}
