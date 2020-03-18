/*
    机器人的运动范围
题目描述
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

public class B66 {
    int sum = 0;

    public int cul(int num){
        int result = 0;
        while (num != 0){
            result += (num % 10);
            num /= 10;
        }
        return result;
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0) return 0;
        int[][] flag = new int[rows][cols];
        char[][] arr = new char[rows][cols];

        process(arr, 0, 0, threshold, flag);

        return sum;
    }

    public void process(char[][] arr, int x, int y, int threshold, int[][] flag) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || flag[x][y] == 1 || (cul(x) + cul(y)) > threshold){
            return ;
        }

        flag[x][y] = 1;
        sum++;
        process(arr, x - 1 , y, threshold, flag);
        process(arr, x + 1 , y, threshold, flag);
        process(arr, x , y - 1, threshold, flag);
        process(arr, x , y + 1, threshold, flag);
    }

}
