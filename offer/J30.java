/*
   包含min函数的栈

题目描述：
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

 */

import java.util.Stack;

public class J30 {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public J30() {
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);
            minStack.push(x);
            return;
        }
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
