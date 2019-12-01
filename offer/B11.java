/*
    调整数组顺序使奇数在偶数前，并保持相对顺序不变
题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

import java.util.Stack;

public class B11 {
    public static void reOrderArray(int [] array) { // 时间复杂度O(n) 空间复杂度O(n)
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0){
                stack2.push(array[i]);
            }else {
                stack1.push(array[i]);
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (!stack2.isEmpty()){
                array[i] = stack2.pop();
            }else if (!stack1.isEmpty()){
                array[i] = stack1.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,5,2,4,3,6,9,8,7,5,1};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
