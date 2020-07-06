/*
    矩阵中的路径

题目描述：
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。

 */

public class J12 {
    public boolean process(char[][] board,int[][] flag, int i, int j, String word){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j] == 1 || word.charAt(0) != board[i][j]) {
            return false;
        }

        if (word.length() == 1) {
            return true;
        }

        flag[i][j] = 1;
        String str = word.substring(1);
        boolean res = process(board, flag, i, j - 1, str) || process(board, flag, i, j + 1, str) || process(board, flag, i - 1, j, str) || process(board, flag, i + 1, j, str);
        flag[i][j] = 0;

        return res;
    }

    public boolean exist(char[][] board, String word) {
        int[][] flag = new int[board.length][board[0].length];
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && process(board, flag, i, j, word) == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
