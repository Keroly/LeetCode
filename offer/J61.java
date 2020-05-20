/*
    扑克牌中的顺子(n)

题目描述：
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。

 */

import java.util.HashSet;

public class J61 {
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int min = 15;
        for (Integer element : nums){
            if (element == 0) {
                continue;
            }else if (set.contains(element)){
                return false;
            }else {
                max = Math.max(max, element);
                min = Math.min(min, element);
                set.add(element);
            }
        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }
}
