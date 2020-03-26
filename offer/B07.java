/*
    斐波那契数列
题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 */

public class B07 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        int a = 0;
        int b = 1;
        while (--n != 0){
            b = a + b;
            a = b - a;
        }
        return b;
    }

}
