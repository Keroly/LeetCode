/*
    机器人的运动范围

题目描述：
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 */

public class J13 {
    public boolean cal (int x, int y, int k) {
        int i = 0;
        int j = 0;
        while (x != 0) {
            i += x % 10;
            x = x / 10;
        }
        while (y != 0) {
            j += y % 10;
            y = y / 10;
        }
        return i + j > k ? true : false;
    }

    public int dfs(int m, int n, int x, int y, int[][] flag, int k) {
        if (x < 0 || x == m || y < 0 || y == n || flag[x][y] == 1 || cal(x, y, k)) {
            return 0;
        }
        flag[x][y] = 1;
        int sum = dfs(m, n, x + 1, y, flag, k) + dfs(m, n, x, y + 1, flag, k);
        return sum + 1;
    }


    public int movingCount(int m, int n, int k) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] flag = new int[m][n];
        return dfs(m, n, 0, 0, flag, k);
    }
}
