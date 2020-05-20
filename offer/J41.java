/*
    数据流中的中位数(nlogn)

题目描述：
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class J41 {
    /** initialize your data structure here. */
    PriorityQueue<Integer> high;
    PriorityQueue<Integer> low;

    public J41() {
        high = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare (Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        low = new PriorityQueue<>(new Comparator<Integer> (){
            public int compare (Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num) {
        if (high.size() == 0) {
            high.add(num);
        }else if (num > high.peek()){
            low.add(num);
        }else {
            high.add(num);
        }

        if (high.size() - 1 > low.size()){
            low.add(high.poll());
        }else if (high.size() + 1 < low.size()){
            high.add(low.poll());
        }

    }

    public double findMedian() {
        if (high.size() == 0) {
            return 0;
        }
        if (high.size() == low.size()){
            return (high.peek() + low.peek()) / 2.0;
        }else {
            return high.size() > low.size() ? high.peek() : low.peek();
        }
    }
}
