/*
    两个栈实现队列(n)

题目描述：
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
(若队列中没有元素，deleteHead 操作返回 -1 )

 */

import java.util.Stack;

public class J09 {
    Stack<Integer> st_1;
    Stack<Integer> st_2;

    public J09() {
        st_1 = new Stack();
        st_2 = new Stack();
    }

    public void appendTail(int value) {
        st_1.push(value);
    }

    public int deleteHead() {
        if (st_2.isEmpty()){
            while (!st_1.isEmpty()){
                st_2.push(st_1.pop());
            }
        }
        if (!st_2.isEmpty()) {
            return st_2.pop();
        }else {
            return -1;
        }
    }
}
