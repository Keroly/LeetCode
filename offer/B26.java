/*
    数组中出现次数超过一半的数
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class B26 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) return 0;
        int cur = array[0];
        int times = 1;
        for (int i = 0; i < array.length; i++) {
            if (times == 0){
                cur = array[i];
                times = 1;
            }else {
                if (cur == array[i]){
                    times++;
                }else {
                    times--;
                }
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == cur){
                times++;
            }
        }
        if (times << 1 <= array.length) return 0;
        return cur;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
