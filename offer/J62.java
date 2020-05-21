/*
    圆圈中最后剩下的数字

题目描述：
0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

 */

import java.util.ArrayList;

public class J62 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList();
        int cur = 0;
        for (int i = 0; i < n; i++){
            list.add(i);
        }
        while(n > 1) {
            cur = (cur + m - 1) % n;
            list.remove(cur);
            n--;
        }
        return list.get(0);
    }
}
