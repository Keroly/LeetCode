/*
    二进制中1的个数
题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class B20 {
//    public static int NumberOf1(int n) {  // 挪动标准
//        int x = 1;
//        int count = 0;
//        while (x != 0){
//            if ((n & x) != 0) count++;
//            x = x << 1;
//        }
//        return count;
//    }

    public static int NumberOf1(int n) {    // 消灭原数
        int count = 0;
        while (n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(3));
    }
}
