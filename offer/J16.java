/*
    数值的整数次方(logn)

题目描述：
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

 */

public class J16 {
    public double process(double x, int n){
        if (x == 0 || x == 1){
            return x;
        }
        if (n == 0) {
            return 1;
        }
        double nums = process(x, n / 2);
        if (n % 2 == 0) {
            return  nums * nums ;
        }else {
            return nums * nums * x;
        }
    }

    public double myPow(double x, int n) {
        int flag = 0;
        if (n < 0){
            flag = -1;
        }else {
            flag = 1;
        }
        return flag > 0 ? process(x, n) : 1 / process(x, -n);
    }
}
