/*
    数组中出现次数超过一半的数(n)

题目描述:
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 */

public class J39 {
    public int majorityElement(int[] nums) {
        int flag = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (flag == 0) {
                flag = 1;
                num = nums[i];
            }else if (nums[i] == num){
                flag += 1;
            }else {
                flag -= 1;
            }
        }
        return num;
    }
}
