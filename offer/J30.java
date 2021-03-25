/*
   包含min函数的栈

题目描述：
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

 */

import java.util.Stack;

public class J30 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** initialize your data structure here. */
    public J30() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty()) {
            s2.push(x);
        }else {
            s2.push(Math.min(x, s2.peek()));
        }
    }

    public void pop() {
        if (!s1.isEmpty()) {
            s1.pop();
            s2.pop();
        }
    }

    public int top() {
        if (!s1.isEmpty()) {
            return s1.peek();
        }
        return -1;
    }

    public int min() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return -1;
    }

}
