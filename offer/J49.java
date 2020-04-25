/*
    丑数(n)

题目描述：
我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

说明:
1 是丑数。
n 不超过1690。

 */

public class J49 {
    public int nthUglyNumber(int index) {
        int[] result = new int[index];
        int p_2 = 0;
        int p_3 = 0;
        int p_5 = 0;
        result[0] = 1;
        for (int i = 1; i < index; i++){
            result[i] = Math.min(result[p_2] * 2, Math.min(result[p_3] * 3, result[p_5] * 5));
            if (result[i] == result[p_2] * 2) {
                p_2++;
            }
            if (result[i] == result[p_3] * 3) {
                p_3++;
            }
            if (result[i] == result[p_5] * 5) {
                p_5++;
            }
        }
        return result[index - 1];
    }
}
