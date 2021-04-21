/*
*
0 0 0 0 0 0 0 1
0 0 0 0 0 0 1 1
0 0 0 0 0 1 0 1
0 0 0 0 1 1 1 1
0 0 0 1 0 0 0 1
0 0 1 1 0 0 1 1
0 1 0 1 0 1 0 1
1 1 1 1 1 1 1 1
*
* */

import java.util.Scanner;

public class test1 {

    private static void process(int[][] ans, int x, int y, int lens) {
        if (lens == 2) {
            ans[x + 1][y] = 1;
            ans[x][y + 1] = 1;
            ans[x + 1][y + 1] = 1;
            return;
        }

        for (int i = x; i < x + lens / 2; i++) {
            for (int j = y; j < y + lens / 2; j++) {
                ans[i][j] = 0;
            }
        }

        int len = lens / 2;

        process(ans, x + len, y, len);
        process(ans, x + len, y + len, len);
        process(ans, x, y + len, len);
    }

    public static void main(String[] args) {
        int[][] ans = new int[1025][1025];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = (int) Math.pow(2, n);
        process(ans, 0, 0, m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
