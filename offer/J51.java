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
        int i = mid;
        int j = end;
        int cur = end;
        while (i >= start && j >= mid + 1){
            if (array[i] > array[j]){
                count += j - mid;
                help[cur--] = array[i--];
            }else {
                help[cur--] = array[j--];
            }
        }
        while (i >= start){
            help[cur--] = array[i--];
        }
        while (j >= mid + 1){
            help[cur--] = array[j--];
        }
        for (int flag = start; flag <= end; flag++){
            array[flag] = help[flag];
        }
        return count;
    }
}
