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

    public int process (int m, int n, int k, int[][] flag, int x, int y){
        if (x < 0 || x >= m || y < 0 || y >=n || flag[x][y] == 1 || (cul(x) + cul(y) > k)){
            return 0;
        }
        flag[x][y] = 1;
        int res = 1;
        res += process(m, n, k, flag, x, y - 1) + process(m, n, k, flag, x, y + 1) + process(m, n, k, flag, x - 1, y) + process(m, n, k, flag, x + 1, y);
        return res;
    }

    public int movingCount(int m, int n, int k) {
        int[][] flag = new int[m][n];
        return process(m, n, k, flag, 0, 0);
    }
}
