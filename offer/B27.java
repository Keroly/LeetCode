/*
    数字在排序数组中出现的次数
题目描述
统计一个数字在排序数组中出现的次数。
 */

public class B27 {
    public static int process(int [] array , double num, int i, int j){
        int mid = (i + j) >> 1;
        if (i == j) return array[i] < num ? i + 1 : i;
        if (i > j) return i;

        if (array[mid] > num){
            return process(array, num, i, mid - 1);
        }else{
            return process(array, num, mid + 1, j);
        }

    }

    public static int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) return 0;
        return process(array, k + 0.5, 0, array.length - 1) - process(array, k - 0.5, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {1};
        System.out.println(GetNumberOfK(array, 4));
    }
}
