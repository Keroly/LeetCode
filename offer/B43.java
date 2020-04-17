/*
    数组中的逆序对

题目描述：
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
并将P对1000000007取模的结果输出。 即输出P%1000000007

输入描述:
题目保证输入的数组中没有的相同的数字
 */

public class B43 {
    int count = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) return 0;
        int[] help = new int[array.length];
        process(array, help, 0, array.length - 1);
        return count;
    }

    public void process(int[] array, int[] help, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1;
        process(array, help, start, mid);
        process(array, help, mid + 1, end);
        int i = mid;
        int j = end;
        int cur = end;
        while (i >= start && j >= mid + 1){
            if (array[i] > array[j]){
                count += j - mid;
                count %= 1000000007;
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
    }
}
