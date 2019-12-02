/*
    数组中重复的数字
题目描述
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */

import java.util.HashSet;
public class B15 {
    public static boolean duplicate(int numbers[],int length,int [] duplication) { // 因为题目特殊，所以有这种时间复杂度O(n) 空间复杂度O(1)的算法
        int i = 0;
        for (i = 0; i < length; i++) {
            if (numbers[i] == numbers[numbers[i]] && numbers[i] != i){ // 数字i 等于 索引为i的位置上的数，但是数字i本身不在索引i上
                duplication[0] = numbers[i];
                return true;
            }else if (numbers[i] != numbers[numbers[i]]){ // 数字i 不等于 索引为i的位置上的数
                int a = numbers[i];
                int b = numbers[numbers[i]];
                numbers[i] = b;
                numbers[a] = a;
                i--;
            }
        }
        return false;
    }

//    public static boolean duplicate(int numbers[],int length,int [] duplication) { // 使用 Hashset  时间复杂度O(n) 空间复杂度O(n)
//        HashSet<Integer> set = new HashSet();
//        for (int i = 0; i < length; i++) {
//            if (set.contains(numbers[i])){
//                duplication[0] = numbers[i];
//                return true;
//            }else {
//                set.add(numbers[i]);
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,4};
        int[] duplication = {-1};
        duplicate(array, 5, duplication);
    }
}
