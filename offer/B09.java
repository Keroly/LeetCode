/*
    变态跳台阶

题目描述：
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

// f(n)     = f(n - 1) + f(n - 2) + ... + f(1)
// f(n - 1) = f(n - 2) + f(n - 3) + ... + f(1)
// f(n) - f(n - 1) = f(n - 1)
// f(n) = 2 f(n - 1) = 4 f(n - 2) = 8 f(n - 3) = 2 ^ (n - 1) f(1) = 2 ^ (n - 1)

public class B09 {
    public  int JumpFloorII(int target) {
        return (int)Math.pow(2, target -1);
    }
}
