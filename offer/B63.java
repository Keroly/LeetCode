/*
    数据流中的中位数
题目描述
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class B63 {
    PriorityQueue<Integer> more = new PriorityQueue<>(new Comparator<Integer>() {   // 大根堆
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    PriorityQueue<Integer> low = new PriorityQueue<>(new Comparator<Integer>() {    //  小根堆
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });

    int count = 0;
    public void Insert(Integer num) {
        if ((count & 1) == 0){
            more.add(num);
            low.add(more.poll());
        }else {
            low.add(num);
            more.add(low.poll());
        }
        count++;
    }

    public Double GetMedian() {
        double result = 0;
        if ((count & 1) == 0){
            result = new Double(more.peek() + low.peek()) / 2;
        }else {
            result = new Double(low.peek());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {5,2,3,4,1,6,7,0,8};
        B63 demo = new B63();
        for (int i = 0; i < num.length; i++) {
            demo.Insert(num[i]);
            System.out.println(demo.GetMedian());
        }
    }
}
