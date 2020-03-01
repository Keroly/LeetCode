/*
    顺时针打印矩阵
题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;
public class B18 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) { // 矩阵通用解法
        ArrayList<Integer> list = new ArrayList();
        int calm_size = matrix.length;
        int vertical_size = matrix[0].length;
        int i = -1;
        int j = -1;
        while (calm_size > 0 && vertical_size >0){
            i++;
            j++;
            while (calm_size == 1 && vertical_size > 0 ){
                list.add(matrix[i][j++]);
                vertical_size--;
            }
            while (calm_size > 0 && vertical_size == 1){
                list.add(matrix[i++][j]);
                calm_size--;
            }
            if (calm_size > 0 && vertical_size >0){
                for (int k = 0; k < vertical_size - 1; k++){
                    list.add(matrix[i][j + k]);
                }
                for (int k = 0; k < calm_size - 1; k++){
                    list.add(matrix[i + k][j + vertical_size - 1]);
                }
                for (int k = 0; k < vertical_size - 1; k++){
                    list.add(matrix[i + calm_size - 1][j + vertical_size - 1 - k]);
                }
                for (int k = 0; k < calm_size - 1; k++){
                    list.add(matrix[i + calm_size - 1 - k][j]);
                }
            }
            calm_size -= 2;
            vertical_size -= 2;
        }
        return list;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        ArrayList list = printMatrix(matrix);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
