/*
    顺时针打印矩阵

题目描述：
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

 */

public class J29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int x = matrix.length;
        int y = matrix[0].length;
        int[] ans = new int[x * y];
        int m = 0;
        int n = 0;
        int flag = 0;
        while (x > 0 && y > 0) {
            while (x == 1 && y-- > 0) {
                ans[flag++] = matrix[m][n++];
            }
            while (y == 1 && x-- > 0) {
                ans[flag++] = matrix[m++][n];
            }
            if (x == 1 || y == 1) {
                return ans;
            }
            for (int i = n; i < n + y - 1; i++) {
                ans[flag++] = matrix[m][i];
            }
            for (int i = m; i < m + x - 1; i++) {
                ans[flag++] = matrix[i][n + y - 1];
            }
            for (int i = n + y - 1; i > n; i--) {
                ans[flag++] = matrix[m + x - 1][i];
            }
            for (int i = m + x - 1; i > m; i--) {
                ans[flag++] = matrix[i][n];
            }
            x = x - 2;
            y = y - 2;
            m++;
            n++;
        }
        return ans;
    }
}
