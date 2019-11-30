/*
    斐波那契数列
题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 */

public class B07 {
    public static int Fibonacci(int n) { // 递归的时间复杂度：O(2^n) 空间：O(1)     此方法时间:O(n) 空间:O(1)
        if (n < 2) return n;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++){
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(6));
    }
}
