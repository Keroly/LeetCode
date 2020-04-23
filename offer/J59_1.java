/*
    滑动窗口的最大值(n)

题目描述：
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

 */

import java.util.LinkedList;

public class J59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return nums;
        }
        int cur = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++){
            while (!list.isEmpty() && nums[i] > nums[list.peekLast()]){
                list.pollLast();
            }
            list.addLast(i);
            if (i < k - 1){
                continue;
            }
            result[cur++] = nums[list.peekFirst()];
            if (list.peekFirst() <= i - k + 1){
                list.pollFirst();
            }
        }
        return result;
    }
}
