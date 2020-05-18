/*
    斐波那契数列(n)

题目描述：
答案需要取模 1e9+7（1000000007）

 */

public class J10_1 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        while (n-- > 1){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}
