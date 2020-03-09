/*
    数组中只出现一次的数字,要求空间复杂度O(1)
题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class B45 {
    public int FindFirstOne(int num){
        int result = 0;
        int flag = 1;
        while (flag != 0){
            if ((num & flag) != 0){
                return result;
            }
            result++;
            flag = flag << 1;
        }
        return result;
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int num = 0;
        int split = 0;

        for (int i = 0; i < array.length; i++){
            num = num ^ array[i];
        }

        split = (int)Math.pow(2, FindFirstOne(num));

        for (int i = 0; i < array.length; i++){
            if ((array[i] & split) == 0){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,1,2,3,3,4,5,6,5,6};
        int[] num1 = {0};
        int[] num2 = {0};
        new B45().FindNumsAppearOnce(array, num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
