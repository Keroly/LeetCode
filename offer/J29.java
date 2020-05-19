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
        int i = 0;
        int j = 0;
        int cur = 0;
        int calm = matrix.length;
        int vertical = matrix[0].length;
        int[] res = new int[calm * vertical];
        while (calm > 0 && vertical > 0) {
            while (calm == 1 && vertical-- != 0) {
                res[cur++] = matrix[i][j++];
            }
            while (vertical == 1 && calm-- != 0) {
                res[cur++] = matrix[i++][j];
            }
            if (calm <= 0 || vertical <= 0){
                break;
            }
            for (int x = j; x < j + vertical - 1; x++){
                res[cur++] = matrix[i][x];
            }
            for (int x = i; x < i + calm - 1; x++){
                res[cur++] = matrix[x][j + vertical - 1];
            }
            for (int x = j + vertical - 1; x > j; x--){
                res[cur++] = matrix[i + calm - 1][x];
            }
            for (int x = i + calm - 1; x > i; x--){
                res[cur++] = matrix[x][j];
            }
            calm -= 2;
            vertical -= 2;
            i++;
            j++;
        }
        return res;
    }
}
