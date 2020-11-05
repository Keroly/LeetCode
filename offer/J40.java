/*
    最小的K个数(nlogn)

题目描述：
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class J40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            return new int[0];
        }
        int[] res = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.add(arr[i]);
                continue;
            }
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
