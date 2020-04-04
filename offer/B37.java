/*
    最小的K个数

题目描述：
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class B37 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input == null || k <= 0 || k > input.length) return result;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < input.length; i++){
            if (queue.size() < k) {
                queue.add(input[i]);
                continue;
            }
            if (input[i] < queue.peek()){
                queue.poll();
                queue.add(input[i]);
            }
        }
        result = new ArrayList<>(queue);
        return result;
    }
}
