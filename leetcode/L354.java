/*
    俄罗斯套娃信封问题

题目描述：
给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

 */

import java.util.Arrays;
import java.util.Comparator;

public class L354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0)
        {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int n = envelopes.length;
        int result = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n;  i++)
        {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--)
            {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (Integer element : dp)
        {
            result = Math.max(result, element);
        }
        return result;
    }
}
