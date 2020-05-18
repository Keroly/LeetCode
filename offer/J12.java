/*
    矩阵中的路径

题目描述：
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。

 */

public class J12 {
    public boolean process(char[][] board, int i, int j, String word, int index, int[][] flag){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j] == 1 || board[i][j] != word.charAt(index)){
            return false;
        }

        if (index == word.length() - 1){
            return true;
        }

        flag[i][j] = 1;
        boolean res = process(board, i + 1, j, word, index + 1, flag)
                || process(board, i - 1, j, word, index + 1, flag)
                || process(board, i, j + 1, word, index + 1, flag)
                || process(board, i, j - 1, word, index + 1, flag);
        flag[i][j] = 0;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                int[][] flag = new int[x][y];
                if (process(board, i, j, word, 0, flag)){
                    return true;
                }
            }
        }
        return false;
    }
}
