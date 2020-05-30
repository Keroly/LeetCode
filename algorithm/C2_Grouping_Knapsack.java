/*
    分组背包问题

题目描述：
有 N 组物品和一个容量是 V 的背包。每组物品有若干个，同一组内的物品最多只能选一个。每件物品的体积是 vij，价值是 wij，其中 i 是组号，j 是组内编号。
求解将哪些物品装入背包，可使物品总体积不超过背包容量，且总价值最大。输出最大价值。

输入格式：
第一行有两个整数 N，V，用空格隔开，分别表示物品组数和背包容量。

接下来有 N 组数据：
每组数据第一行有一个整数 Si，表示第 i 个物品组的物品数量；
每组数据接下来有 Si 行，每行有两个整数 vij,wij，用空格隔开，分别表示第 i 个物品组的第 j 个物品的体积和价值；

输出格式：
输出一个整数，表示最大价值。

 */

import java.util.Scanner;

public class C2_Grouping_Knapsack {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n ;i++)
        {
            int num = sc.nextInt();
            int[] v = new int[num + 1];
            int[] w = new int[num + 1];
            for (int j = 1; j <= num; j++)
            {
                v[j] = sc.nextInt();
                w[j] = sc.nextInt();
            }

            for (int j = m; j >= 0; j--)
            {
                for (int k = 1; k <= num; k++) {
                    if (j >= v[k])
                    {
                        dp[j] = Math.max(dp[j], dp[j - v[k]] + w[k]);

                    }
                }
            }

        }
        System.out.println(dp[m]);
    }
}

