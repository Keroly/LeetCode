/*
    二进制中1的个数(1)

题目描述：
请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

 */

public class J15 {
    public int hammingWeight(int n) {
        int flag = 1;
        int sum = 0;
        while (flag != 0) {
            if ((n & flag) != 0) {
                sum++;
            }
            flag = flag << 1;
        }
        return sum;
    }
}
