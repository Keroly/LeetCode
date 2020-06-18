/*
    岛屿数量

题目描述：
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

 */
public class L200 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int result = 0;
        int calm = grid.length;
        int vertical = grid[0].length;
        int[][] flag = new int[calm][vertical];
        for (int i = 0; i < calm; i++){
            for (int j = 0; j < vertical; j++){
                if (flag[i][j] == 1) continue; // 被访问过
                process(grid, flag, i, j, calm, vertical);
                if (grid[i][j] != '0'){ // 这个位置不是水
                    result += 1;
                }
            }
        }
        return result;
    }

    public void process(char[][] grid, int[][] flag, int i, int j, int calm, int vertical) {
        if (i < 0 || i >= calm || j < 0 || j >= vertical ) return;  // 越界
        if (flag[i][j] == 1) return; // 被访问过
        if (grid[i][j] == '0') {  // 遇到水
            flag[i][j] = 1;
            return;
        }
        flag[i][j] = 1;
        process(grid, flag, i + 1, j, calm, vertical);
        process(grid, flag, i - 1, j, calm, vertical);
        process(grid, flag, i, j + 1, calm, vertical);
        process(grid, flag, i, j - 1, calm, vertical);
    }
}
