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
        int x = 0;
        int y = matrix[0].length - 1;
        while (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] < target) {
                x ++;
            }else {
                y --;
            }
        }
        return false;
    }
}
