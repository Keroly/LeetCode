/*
    二维费用背包问题

题目描述：
有 N 件物品和一个容量是 V 的背包，背包能承受的最大重量是 M。
每件物品只能用一次。体积是 vi，重量是 mi，价值是 wi。
求解将哪些物品装入背包，可使物品总体积不超过背包容量，总重量不超过背包可承受的最大重量，且价值总和最大。输出最大价值。

输入格式：
第一行两个整数，N，V,M，用空格隔开，分别表示物品件数、背包容积和背包可承受的最大重量。
接下来有 N 行，每行三个整数 vi,mi,wi，用空格隔开，分别表示第 i 件物品的体积、重量和价值。

输出格式：
输出一个整数，表示最大价值。

 */

import java.util.Scanner;

public class C2_2DCost_Knapsack {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int V = reader.nextInt();
        // 背包的最大承受重量为W
        int M = reader.nextInt();
        // 第i个元素表示第i个物品的体积；
        int[] v = new int[N + 1] ;
        // 第i个元素表示第i个物品的价值；
        int[] w = new int[N + 1] ;
        // 第i个元素表示第i个物品的重量；
        int[] m = new int[N + 1];

        for (int i = 1 ; i <= N ;i++)
        {
            v[i] = reader.nextInt();
            m[i] = reader.nextInt();
            w[i] = reader.nextInt();
        }
        reader.close() ;

        int[][] dp = new int[M + 1][V + 1];
        for (int i = 1; i <= N; i++)
        {
            for (int j = M; j >= m[i]; j--)
            {
                for (int k = V; k >= v[i]; k--)
                {
                        dp[j][k] = Math.max(dp[j - m[i]][k -v[i]] + w[i], dp[j][k]);
                }
            }
        }

        System.out.println(dp[M][V]);
    }
}
