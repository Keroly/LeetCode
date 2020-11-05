/*
    数据流中的中位数(nlogn)

题目描述：
如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class J41 {
    PriorityQueue<Integer> high;
    PriorityQueue<Integer> low;

    /** initialize your data structure here. */
    public J41() {
        high = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        low = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }

    public void addNum(int num) {
        if (high.size() == 0) {
            high.add(num);
            return;
        }
        if (num <= high.peek()) {
            high.add(num);
        }else {
            low.add(num);
        }
        while (low.size() > high.size()) {
            high.add(low.poll());
        }
        while (high.size() > low.size() + 1) {
            low.add(high.poll());
        }
    }

    public double findMedian() {
        if (high.size() == 0) {
            return 0;
        }
        if (low.size() != high.size()) {
            return high.peek();
        }else {
            return (high.peek() + low.peek()) / 2.0;
        }
    }
}
