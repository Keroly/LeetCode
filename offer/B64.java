/*
    滑动窗口的最大值
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class B64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>(); // 存下标
        if (num == null || num.length == 0 || size < 1) return result;
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] >= num[queue.peekLast()]){    // 扩
                queue.pollLast();
            }

            queue.addLast(i);   //扩

            if (queue.peekFirst() == i - size) {    // 缩
                queue.pollFirst();
            }

            if (i >= size - 1) {
                result.add(num[queue.peekFirst()]); // 找最大值
            }
        }
        return result;
    }
}
