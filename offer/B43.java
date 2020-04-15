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
    public void process(int[] array, int[] help, int left, int right){
        if (left == right) return;
        int mid = (left + right) >> 1;
        process(array, help, left, mid);
        process(array, help, mid + 1, right);
        int p_left = mid;
        int p_right = right;
        int p_help = right;

        while (p_left >= left && p_right > mid){
            if (array[p_left] > array[p_right]){
                count += (p_right - mid);
                if(count >= 1000000007)     // 数值过大求余
                {
                    count %= 1000000007;
                }
                help[p_help--] = array[p_left--];
            }else {
                help[p_help--] = array[p_right--];
            }
        }

        while (p_left >= left) {
            help[p_help--] = array[p_left--];
        }

        while (p_right > mid){
            help[p_help--] = array[p_right--];
        }

        for (int i = left; i <= right; i++){
            array[i] = help[i];
        }
    }

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) return 0;
        int[] help = new int[array.length];
        process(array, help, 0, array.length - 1);
        return count % 1000000007;
    }
}
