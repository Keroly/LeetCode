/*
    完全背包问题

题目描述：
有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。第 i 种物品的体积是 vi，价值是 wi。
求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。输出最大价值。

输入格式：
第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 种物品的体积和价值。

输出格式：
输出一个整数，表示最大价值。

 */

import java.util.Scanner;

public class C2_Complete_Knapsack {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int V = reader.nextInt();
        // 一个长度为N的数组，第i个元素表示第i个物品的体积；
        int[] v = new int[N + 1] ;
        // 一个长度为N的数组，第i个元素表示第i个物品的价值；
        int[] w = new int[N + 1] ;

        for (int i = 1 ; i <= N ;i++)
        {
            v[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        reader.close() ;

        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++)
        {
            for (int j = 0; j <= V; j++)
            {
                if (j - v[i] >= 0)
                {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                }else {
                    dp[j] = dp[j];
                }
            }
        }
        System.out.println(dp[V]);


    }
}