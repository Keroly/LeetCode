/*
    矩阵中的路径

题目描述：
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。

 */

public class J12 {
    public boolean dfs (char[][] board, int x, int y, String word, int index, int[][] flag) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index) || flag[x][y] == 1) {
            return false;
        }
        flag[x][y] = 1;
        boolean res = dfs(board, x, y + 1, word, index + 1, flag) || dfs(board, x, y - 1, word, index + 1, flag) ||
                dfs(board, x + 1, y, word, index + 1, flag) || dfs(board, x - 1, y, word, index + 1, flag);
        flag[x][y] = 0;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length == 0) {
            return false;
        }
        int[][] flag = new int[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (dfs(board, x, y, word, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }
}
