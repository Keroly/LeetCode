/*
    数值的整数次方(logn)

题目描述：
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

 */

public class J16 {
    public double cal (double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = cal(x, n / 2);
        if (n % 2 == 1) {
            return res * res * x;
        }else {
            return res * res;
        }
    }
    public double myPow(double x, int n) {
        if (n > 0) {
            return cal(x, -n);
        }
        return 1 / cal(x, n);
    }
}
