/*
    二维数组中的查找(n + m)

题目描述：
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 */

public class J04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = matrix.length;
        int j = matrix[0].length;
        int m = 0;
        int n = j - 1;
        while (m >= 0 && m < i && n >= 0 && n < j) {
            if (matrix[m][n] > target) {
                n--;
            }else if (matrix[m][n] < target) {
                m++;
            }else {
                return true;
            }
        }
        return false;
    }
}
