/*
    数组中出现次数超过一半的数(n)

题目描述:
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 */

public class J39 {
    public int majorityElement(int[] nums) {
        int res = 0;
        int times = 0;
        for (Integer element : nums) {
            if (times == 0) {
                res = element;
                times++;
            }else if (res == element) {
                times++;
            }else {
                times--;
            }
        }
        return res;
    }
}
