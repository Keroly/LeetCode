/*
    解码方法

题目描述：
一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

 */

public class L091 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            if(!s.substring(i - 1,  i).equals("0"))
            {
                dp[i] += dp[i - 1];
            }
            if (i >= 2)
            {
                int num = Integer.parseInt(s.substring(i - 2, i));
                if (num >= 10 && num <= 26)
                {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
