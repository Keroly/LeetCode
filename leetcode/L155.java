/*
    最小栈

题目描述：
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    push(x) —— 将元素 x 推入栈中。
    pop() —— 删除栈顶的元素。
    top() —— 获取栈顶元素。
    getMin() —— 检索栈中的最小元素。
 */

import java.util.LinkedList;

public class L155 {
    LinkedList<Integer> element;
    LinkedList<Integer> min;

    public L155() {
        element = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        element.addLast(x);
        if (!min.isEmpty() && min.peekLast() < x){
            min.addLast(min.peekLast());
        }else {
            min.addLast(x);
        }
    }

    public void pop() {
        if (!element.isEmpty()){
            element.pollLast();
            min.pollLast();
        }
    }

    public int top() {
        if (!element.isEmpty()){
            return element.peekLast();
        }
        return -1;
    }

    public int getMin() {
        if (!min.isEmpty()){
            return min.peekLast();
        }
        return -1;
    }
}
