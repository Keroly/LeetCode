/*
    矩阵中的路径

题目描述：
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。

 */

public class J12 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        char[] chs = word.toCharArray();
        int[][] flag = new int[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (dfs(board, x, y, flag, chs, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, int[][] flag, char[] chs, int num) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || flag[x][y] == 1 || num >= chs.length || board[x][y] != chs[num]) {
            return false;
        }
        if (num == chs.length - 1) {
            return true;
        }
        flag[x][y] = 1;
        boolean ans = dfs(board, x + 1, y, flag, chs, num + 1) || dfs(board, x - 1, y, flag, chs, num + 1) ||
                dfs(board, x, y + 1, flag, chs, num + 1) || dfs(board, x, y - 1, flag, chs, num + 1);
        flag[x][y] = 0;
        return ans;
    }

}
