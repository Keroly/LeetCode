/*
    爬楼梯

题目描述：
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 */

public class L070 {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++){
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
