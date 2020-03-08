/*
    丑数
题目描述
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class B41 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int[] result = new int[index];
        result[0] = 1;
        int p_2 = 0;    // 乘2队列的 没被加入数组的 最小的数 是由result数组中第几位乘2得到的
        int p_3 = 0;    // 乘3队列的 没被加入数组的 最小的数 是由result数组中第几位乘3得到的
        int p_5 = 0;    // 乘5队列的 没被加入数组的 最小的数 是由result数组中第几位乘5得到的
        for (int i = 1; i < index; i++){
            result[i] = Math.min(result[p_2] * 2,Math.min(result[p_3] * 3, result[p_5] * 5)); // 队头中哪个数最小
            if (result[i] == result[p_2] * 2) p_2++;    // 如果刚才添加的元素等于队头元素则后移一位
            if (result[i] == result[p_3] * 3) p_3++;
            if (result[i] == result[p_5] * 5) p_5++;
        }
        return result[index - 1];
    }
}
