/*
    把数组排成最小的数

题目描述：
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

 */

import java.util.ArrayList;
import java.util.Comparator;

public class J45 {
    public String minNumber(int[] nums) {

        String res = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return (o1 + "" + o2).compareTo(o2 + "" + o1);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            res += list.get(i);
        }
        return res;
    }
}
