/*
    数值的整数次方
题目描述：
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0
 */

public class B33 {
    public static double process(double base, int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        if ((exponent & 1) == 1){
            return process(base, (exponent - 1) >> 1) * process(base, (exponent - 1) >> 1) * base;
        }else {
            return process(base, exponent >> 1) * process(base, exponent >> 1);
        }
    }

    public static double Power(double base, int exponent) {
        if (base == 0 && exponent == 0) return 0;
        int e = exponent > 0 ? exponent : -exponent;
        double result = process(base,e);
        return exponent > 0 ? result : 1 / result;
    }

    public static void main(String[] args) {
        System.out.println(Power(2, -2));
    }
}
