/*
    数组中数字出现的次数(n)

题目描述：
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)

 */

public class J56_1 {

    public int[] singleNumbers(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }

        int b = 1;
        while (b != 0) {
            if ((a & b) != 0) {
                break;
            }
            b <<= 1;
        }

        int res1 = 0;
        int res2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & b) == 0) {
                res1 ^= nums[i];
            }else {
                res2 ^= nums[i];
            }
        }

        return new int[]{res1, res2};
    }
}
