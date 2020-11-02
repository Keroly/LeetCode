/*
    旋转数组的最小数字(logn)

题目描述：
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。

 */

public class J11 {
    public int minArray(int[] numbers) {
        int m = 0;
        int n = numbers.length - 1;
        while (n > 0 && numbers[n] == numbers[0]) {
            n--;
        }
        if (numbers[n] >= numbers[0]) {
            return numbers[0];
        }
        while (m < n) {
            int mid = (m + n) >> 1;
            if (numbers[mid] >= numbers[0]) {
                m = mid + 1;
            }else {
                n = mid;
            }
        }
        return numbers[m];
    }
}
