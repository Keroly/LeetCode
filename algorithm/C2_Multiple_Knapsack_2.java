/*
    多重背包问题

题目描述：
有 N 种物品和一个容量是 V 的背包。第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。输出最大价值。

输入格式：
第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。

输出格式：
输出一个整数，表示最大价值。

 */

import java.util.ArrayList;
import java.util.Scanner;

public class C2_Multiple_Knapsack_2 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int V = reader.nextInt();
        // 一个长度为N的数组，第i个元素表示第i个物品的体积；
        ArrayList<Integer> v = new ArrayList<>();
        // 一个长度为N的数组，第i个元素表示第i个物品的价值；
        ArrayList<Integer> w = new ArrayList<>();
        v.add(0);
        w.add(0);

        for (int i = 1 ; i <= N ;i++)
        {
            int a = reader.nextInt();
            int b = reader.nextInt();
            int c = reader.nextInt();
            for (int k = 1; k <= c; k *= 2)
            {
                c -= k;
                v.add(k * a);
                w.add(k * b);
            }
            if (c > 0)
            {
                v.add(c * a);
                w.add(c * b);
            }
        }
        reader.close() ;

        int[] dp = new int[v.size()];
        for (int i = 1; i < v.size(); i++)
        {
            for (int j = V; j - v.get(i) >= 0; j--)
            {
                dp[j] = Math.max(dp[j], dp[j - v.get(i)] + w.get(i));
            }
        }

        System.out.println(dp[V]);
    }
}

