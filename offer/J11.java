/*
    旋转数组的最小数字(logn)

题目描述：
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。

 */

public class J11 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        int mid = 0;
        while (low < high) {
            mid = (low + high) >> 1;
            if (numbers[low] < numbers[high]){
                return numbers[low];
            }
            if (numbers[mid] > numbers[low]){
                low = mid;
            }else if (numbers[mid] < numbers[low]){
                high = mid;
            }else{
                low++;
            }
        }
        return numbers[low];
    }
}
