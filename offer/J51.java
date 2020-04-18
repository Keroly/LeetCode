/*
    数组中的逆序对

题目描述：
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

 */

public class J51 {
    public int reversePairs(int[] array) {
        if (array == null || array.length <= 1) return 0;
        int[] help = new int[array.length];
        return process(array, help, 0, array.length - 1);
    }

    public int process(int[] array, int[] help, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) >> 1;
        int result_1 = process(array, help, start, mid);
        int result_2 = process(array, help, mid + 1, end);
        int count = result_1 + result_2;
        int p_left = mid;
        int p_right = end;
        int cur = end;
        while (p_left >= start && p_right >= mid + 1){
            if (array[p_left] > array[p_right]){
                count += p_right - mid;
                help[cur--] = array[p_left--];
            }else {
                help[cur--] = array[p_right--];
            }
        }
        while (p_left >= start){
            help[cur--] = array[p_left--];
        }
        while (p_right >= mid + 1){
            help[cur--] = array[p_right--];
        }
        for (int i = start; i <= end; i++){
            array[i] = help[i];
        }
        return count;
    }
}
