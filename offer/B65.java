/*
    矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */

public class B65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || rows <= 0 || cols <= 0) return false;
        int[][] flag = new int[rows][cols];
        char[][] arr = new char[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                arr[i][j] = matrix[count++];
            }
        }

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (process(arr, i, j, str, 0, flag)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean process(char[][] arr, int x, int y, char[] str, int index, int[][] flag) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || flag[x][y] == 1){
            return false;
        }
        if (arr[x][y] != str[index]){
            return false;
        }
        if (index == str.length - 1){
            return true;
        }

        flag[x][y] = 1;

        boolean result = process(arr, x - 1 , y, str, index + 1, flag)
                        || process(arr, x + 1 , y, str, index + 1, flag)
                        || process(arr, x , y - 1, str, index + 1, flag)
                        || process(arr, x , y + 1, str, index + 1, flag);

        flag[x][y] = 0;

        return result;
    }
}
