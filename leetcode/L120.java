/*
    三角形最小路径和

题目描述：
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 空间复杂度O(n)

 */

import java.util.List;

public class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i ++) {
            int pre = dp[0];
            int cur = dp[0];
            for (int j = 0; j <= i; j++) {
                if (j > 0 && i != j) {
                    cur = dp[j];
                    dp[j] = Math.min(dp[j], pre) + triangle.get(i).get(j);
                    pre = cur;
                }else if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }else {
                    dp[j] = pre + triangle.get(i).get(j);
                }
            }
        }
        for (Integer element : dp) {
            res = Math.min(res, element);
        }
        return res;
    }
}
