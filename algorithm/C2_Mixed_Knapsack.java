/*
    混合背包问题

题目描述：
有 N 种物品和一个容量是 V 的背包。物品一共有三类：
第一类物品只能用1次（01背包）；
第二类物品可以用无限次（完全背包）；
第三类物品最多只能用 si 次（多重背包）；
每种体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。输出最大价值。

输入格式：
第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
si=−1 表示第 i 种物品只能用1次；
si=0 表示第 i 种物品可以用无限次；
si>0 表示第 i 种物品可以使用 si 次

输出格式：
输出一个整数，表示最大价值。

 */

import java.util.ArrayList;
import java.util.Scanner;

public class C2_Mixed_Knapsack {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        // 物品的数量为N
        int N = reader.nextInt();
        // 背包的容量为V
        int V = reader.nextInt();
        // 第i个元素表示第i个物品的体积；
        ArrayList<Integer> v = new ArrayList<>();
        // 第i个元素表示第i个物品的价值；
        ArrayList<Integer> w = new ArrayList<>();
        // 第i个元素表示第i个物品类型
        ArrayList<Integer> k = new ArrayList<>();
        v.add(0);
        w.add(0);
        k.add(0);

        for (int i = 1 ; i <= N ;i++)
        {
            int a = reader.nextInt();
            int b = reader.nextInt();
            int c = reader.nextInt();
            if (c < 1)
            {
                v.add(a);
                w.add(b);
                k.add(c);
            }else {
                for (int m = 1; m <= c; m *= 2)
                {
                    c -= m;
                    v.add(m * a);
                    w.add(m * b);
                    k.add(-1);
                }
                if (c > 0)
                {
                    v.add(c * a);
                    w.add(c * b);
                    k.add(-1);
                }
            }
        }
        reader.close() ;

        int[] dp = new int[V + 1];
        for (int i = 1; i < v.size(); i++)
        {
            if (k.get(i) == -1)
            {
                for (int j = V; j - v.get(i) >= 0; j--)
                {
                    dp[j] = Math.max(dp[j], dp[j - v.get(i)] + w.get(i));
                }
            }else {
                for (int j = 0; j <= V; j++){
                    if (j - v.get(i) >= 0)
                    {
                        dp[j] = Math.max(dp[j], dp[j - v.get(i)] + w.get(i));
                    }
                }
            }
        }

        System.out.println(dp[V]);
    }
}
