/*
    前k个高频元素

题目描述：
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 */

import java.util.*;

public class L347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer element: nums) {
            if (map.containsKey(element)){
                map.put(element, map.get(element) + 1);
            }else {
                map.put(element, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer element: map.keySet()) {
            if (queue.size() < k){
                queue.add(element);
            }else if (map.get(element) > map.get(queue.peek())){
                    queue.poll();
                    queue.add(element);
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (queue.size() != 0){
            result.addFirst(queue.poll());
        }

        return result;
    }
}
