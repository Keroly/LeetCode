/*
    滑动窗口的最大值

题目描述：
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
 
进阶：
你能在线性时间复杂度内解决此题吗？

 */

import java.util.LinkedList;

public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int flag = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
            while (!list.isEmpty() && nums[list.peekLast()] < nums[i]){
                list.pollLast();
            }

            list.addLast(i);

            if (i - list.peekFirst() == k){
                list.pollFirst();
            }

            if (i >= k - 1){
                result[flag++] = nums[list.peekFirst()];
            }
        }
        return result;
    }
}
