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
        if (n == 1) {
            return x;
        }
        if (n == 2) {
            return x * x;
        }

        double res = cal(x, n / 2);
        if (n % 2 == 0) {
            return res * res;
        }else {
            return x * res * res;
        }

    }
    public double myPow(double x, int n) {

        int flag = n > 0 ? n : 0 - n;

        double ans = cal(x, n);

        if (n > 0) {
            return ans;
        }

        return 1 / ans;
    }
}
