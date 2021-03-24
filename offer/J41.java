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
        if (high.size() == low.size()) {
            high.add(num);
            low.add(high.poll());
        }else {
            low.add(num);
            high.add(low.poll());
        }
    }

    public double findMedian() {
        if (high.size() == low.size()) {
            return (high.peek() + low.peek()) / 2.0;
        }else {
            if (high.size() > low.size()) {
                return high.peek();
            }else {
                return low.peek();
            }
        }
    }
}
