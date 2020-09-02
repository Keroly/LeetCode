/*
    单词搜索

题目描述：
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 */

public class L079 {
    public boolean dfs(char[][] board, int x, int y, char[] arr, int start, int[][] flag) {
        if (x < 0 || y < 0|| x == board.length || y == board[0].length || board[x][y] != arr[start] || flag[x][y] == 1) return false;
        if (start == arr.length - 1) return true;
        flag[x][y] = 1;
        boolean res =  dfs(board, x + 1, y, arr, start + 1, flag) ||
                            dfs(board, x - 1, y, arr, start + 1, flag) ||
                            dfs(board, x, y + 1, arr, start + 1, flag) ||
                            dfs(board, x, y - 1, arr, start + 1, flag);
        flag[x][y] = 0;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) return false;
        char[] arr = word.toCharArray();
        int[][] flag = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs (board, i, j, arr, 0, flag) == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
