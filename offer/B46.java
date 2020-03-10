/*
    和为S的连续正数序列
题目描述：
找出所有和为S的连续正数序列
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B46 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 1) return result;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int count = 1;
        int cur = 1;
        while (cur <= (sum >> 1) + 1){
            if (count <= sum){
                if (count == sum) result.add(new ArrayList<Integer>(queue));
                queue.offer(++cur);
                count += cur;
            }else {
                count -= queue.peek();
                queue.poll();
            }
        }
        return result;
    }
}
