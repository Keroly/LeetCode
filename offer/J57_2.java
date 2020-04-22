/*
    和为s的连续正数序列(n)

题目描述：
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列

 */


import java.util.ArrayList;
import java.util.List;

public class J57_2 {
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 2;
        int sum = 3;
        int flag = (target + 1) / 2;
        List<int[]> list = new ArrayList();
        while (i < j && j <= flag){
            if (sum > target){
                sum -= i;
                i++;
            }else if(sum < target){
                j++;
                sum += j;
            }else{
                int[] res = new int[j - i + 1];
                for (int k = i;  k <= j; k++){
                    res[k - i] = k;
                }
                list.add(res);
                j++;
                sum += j;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
