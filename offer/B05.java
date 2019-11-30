/*
    用两个栈实现队列
题目描述
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

import java.util.Stack;

public class B05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()){

        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        B05 t = new B05();
        t.push(0);
        t.push(1);
        t.push(2);
        t.push(3);
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
    }
}
