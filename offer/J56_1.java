/*
    数组中数字出现的次数(n)

题目描述：
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)

 */

public class J56_1 {
    public int searchFirstOne(int num){
        int flag = 1;
        while (flag != 0){
            if ((num & flag) != 0){
                return flag;
            }
            flag <<= 1;
        }
        return flag;
    }

    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        int nums0 = 0;
        int nums1 = 0;
        int flag = 0;
        for(int element : nums){
            flag ^= element;
        }
        flag = searchFirstOne(flag);
        for (int element : nums){
            if ((element & flag) == 0){
                nums0 ^= element;
            }else {
                nums1 ^= element;
            }
        }
        result[0] = nums0;
        result[1] = nums1;
        return result;
    }


}
