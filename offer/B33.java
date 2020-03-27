/*
    数值的整数次方
题目描述：
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0
 */

public class B33 {
    public double process(double base, int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double sum = process(base, exponent / 2);
        double result = sum * sum;
        if ((exponent & 1) == 1){
            return result * base;
        }
        return result;
    }

    public double Power(double base, int exponent) {
        if (base == 0 || base == 1) return base;
        double result = process(base, Math.abs(exponent));
        return exponent > 0 ? result : 1.0 / result;
    }

}
