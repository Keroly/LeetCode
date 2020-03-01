/*
    栈的压入弹出序列
题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）
 */

import java.util.ArrayList;
import java.util.Stack;

public class B23 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length || pushA.length == 0) return false;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int j = 0;
        stack.push(pushA[i++]);
        while(j < popA.length){
            while(popA[j] != stack.peek()){
                if(i == pushA.length) return false; // 失败的条件：push数组遍历完了，不能再出现栈顶与pop不相等的情况
                stack.push(pushA[i++]);
            }
            j++;
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        int [] pushA = {1,2,3,4,5};
        int [] popA = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushA, popA));
    }
}
