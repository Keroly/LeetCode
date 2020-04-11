/*
    多数元素

题目描述：
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

public class L169 {
    public int majorityElement(int[] nums) {
        int times = 0;
        int result = 0;
        for (Integer element: nums) {
            if (times == 0){
                result = element;
                times += 1;
            }else {
                if (element == result){
                    times += 1;
                }else {
                    times -= 1;
                }
            }
        }
        return result;
    }
}
