/*
    跳台阶

题目描述：
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

public class B08 {
    public int JumpFloor(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        int a = 1;
        int b = 2;
        while (target-- != 2){
            b = a + b;
            a = b - a;
        }
        return b;
    }
}

// 时间：O(n)  空间：O(1)

