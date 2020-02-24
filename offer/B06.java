/*
    旋转数组的最小数字
题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

public class B06 {
    public static int minNumberInRotateArray(int [] array) { // 错误的mid位置,往左侧看应当大于low位置，否则往右侧看赢小于等于high位置
        if (array.length == 0) return 0;
        int low = 0;
        int mid = (array.length - 1) >> 1;
        int high = array.length - 1;
        while (low < high){
            if (array[low] < array[high]){
                return array[low];
            }
            mid = low + (high - low) / 2;
            if (array[mid] > array[low]){
                low = mid;
            }else if (array[mid] < array[high]){
                high = mid;
            }else {     // 不存在 mid 比 low 小的同时比 high 大, 唯一的可能就是 mid 与任意一端的值相等
                low++;  // 由于low >= high 且 mid与任意一端相等，自然可以使 low 右移
            }
        }
        return array[low];
    }
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1};
        int[] arr1 = {0,1,1,1,1};
        int[] arr2 = {1,1,1,1,0};
        System.out.println(minNumberInRotateArray(arr));
        System.out.println(minNumberInRotateArray(arr1));
        System.out.println(minNumberInRotateArray(arr2));
    }
}
