/*
    数组中的第k大元素

题目描述：
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */

import java.util.PriorityQueue;

public class L215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (Integer element: nums) {
            if (queue.size() < k){
                queue.add(element);
            }else if (element > queue.peek()){
                    queue.poll();
                    queue.add(element);
                }
        }
        return queue.poll();
    }
}
