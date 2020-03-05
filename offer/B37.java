/*
    最小的K个数
题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
public class B37 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k > input.length || k == 0){
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++){
            if (queue.size() < k){
                queue.offer(input[i]);
            }else {
                if (queue.peek() > input[i]){
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }
        for (Integer integer: queue) {
            result.add(integer);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {8,3,5,11,7};
        ArrayList list = new B37().GetLeastNumbers_Solution(array,2);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
