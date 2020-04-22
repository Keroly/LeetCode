/*
    数组中数字出现的次数(n)

题目描述：
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字

 */

public class J56_2 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++){
            int count = 0;
            for (int element : nums){
                if  ((element & (1 << i) )!= 0){
                    count++;
                }
            }
            if (count % 3 != 0){
                result ^= (1 << i);
            }
        }
        return result;
    }
}
