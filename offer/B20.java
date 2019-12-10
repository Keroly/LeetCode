/*
    二进制中1的个数
题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class B20 {
    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((n & flag ) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(3));
    }
}