/*
    队列的最大值(1)

题目描述：
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1

 */

import java.util.LinkedList;

public class J59_2 {
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
