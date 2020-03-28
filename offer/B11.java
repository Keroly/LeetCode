/*
    调整数组顺序使奇数在偶数前，并保持相对顺序不变

题目描述：
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

import java.util.Stack;

public class B11 {
//------------------------------------------ 扰乱相对次序  ---------------------------------------------------------------
    public void reOrderArray(int [] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j){
            while (i < j && (array[i] & 1) == 1){
                i++;
            }

            while (i < j && (array[j] & 1) == 0){
                j--;
            }

            if (i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
    }
//------------------------------------------  保持相对次序  --------------------------------------------------------------
    public void reOrderArray_2(int [] array) {
        Stack<Integer> stack_0 = new Stack<>();
        Stack<Integer> stack_1 = new Stack<>();

        for (int i = 0; i < array.length; i++){
            if ((array[i] & 1) == 1){
                stack_1.add(array[i]);
            }else {
                stack_0.add(array[i]);
            }
        }

        int i = array.length - 1;

        while (!stack_0.isEmpty()){
            array[i--] = stack_0.pop();
        }

        while (!stack_1.isEmpty()){
            array[i--] = stack_1.pop();
        }
    }
}

// 时间：O(n) 空间：O(n)
