/*
    不用加减乘除做加法

题目描述：
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

 */

public class J65 {
    public int add(int a, int b) {
        while (b != 0) {
            int cul = (a ^ b);
            b = (a & b) << 1;
            a = cul;
        }
        return a;
    }
}
