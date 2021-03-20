/*
    旋转数组的最小数字(logn)

题目描述：
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。

 */

public class J11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (right >= 0 && numbers[left] == numbers[right]) {
            right--;
        }
        while (left < right) {
            if (numbers[left] < numbers[right]) {
                return numbers[left];
            }
            int mid = (left + right)/ 2;
            if (numbers[mid] >= numbers[left]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return numbers[left];
    }
}
