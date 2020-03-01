/*
    包含min函数的栈
题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

import java.util.Stack;
public class B22 {
    static Stack<Integer> data = new Stack();
    static Stack<Integer> min = new Stack();
    public static void push(int node) {
        data.push(node);
        if (min.isEmpty()) min.push(node);
        if (node < min.peek()){
            min.push(node);
        }else {
            min.push(min.peek());
        }
    }

    public static void pop() {
        if (!data.isEmpty() && !min.isEmpty()){
            data.pop();
            min.pop();
        }
    }

    public static int top() {
        if (!data.isEmpty()){
            return data.peek();
        }
        return -1;
    }

    public static int min() {
        if (!min.isEmpty()){
            return min.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        B22 stack = new B22();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(2);
        stack.push(2);
        stack.pop();
        stack.pop();
        System.out.println(B22.min());
    }
}
