/*
    机器人的运动范围

题目描述：
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 */

public class J13 {
    public int cul (int i){
        int res = 0;
        while (i != 0){
            res += (i % 10);
            i = i / 10;
        }
        return res;
    }

    public int process (int[][] flag, int i, int j, int k){
        int count = 0;
        if (i >= 0 && i < flag.length && j >= 0 && j < flag[0].length && flag[i][j] == 0 && cul(i) + cul(j) <= k) {
            count += 1;
            flag[i][j] = 1;
            count += process(flag, i, j - 1, k) + process(flag, i, j + 1, k) + process(flag, i - 1, j, k) + process(flag, i + 1, j, k);
        }
        return count;
    }

    public int movingCount(int m, int n, int k) {
        int[][] flag = new int[m][n];
        return process(flag, 0, 0, k);
    }
}
