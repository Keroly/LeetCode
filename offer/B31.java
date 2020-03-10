/*
    扑克牌顺子
题目描述
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子
“红心A,黑桃3,小王,大王,方片5”,不是顺子.....LL决定大\小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4)。
现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */


import java.util.HashSet;

public class B31 {
    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) return false;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                continue;
            }
            if (set.contains(numbers[i])) return false;
            set.add(numbers[i]);
            max = max > numbers[i] ? max : numbers[i];
            min = min < numbers[i] ? min : numbers[i];
        }

        if (Math.abs(max - min) >= 5) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,6,5};
        System.out.println(isContinuous(nums));
    }
}
