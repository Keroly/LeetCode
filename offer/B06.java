/*
    旋转数组的最小数字
题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

public class B06 {
    public static int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return 0;
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while(low < high){
            if (array[low] < array[high]) // 如果array本身就是排好序的
                return array[low];
            mid = low + (high - low) / 2;
            if(array[mid] > array[low]) // low 向右移动
                low = mid + 1; // 如果mid属于左侧，那么mid可以直接排除，因为答案一定在右侧
            else if(array[mid] < array[high]) // high 向左移动
                high = mid; // 如果mid属于右侧，那么mid不可以排除，因为答案一定在右侧
            else low++; // 如果array[mid]等于array[low / high]中的任何一个都把low右移重新计算mid，因为如果low位置是唯一答案应该早已被判断出  1234 / 1111
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
