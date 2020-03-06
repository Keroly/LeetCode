/*
    整数中1出现的次数
题目描述
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class B39 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) return 0;
        int count = 0;
        for (long i = 1; i <= n; i = i * 10){ // i 可用来代表某位上最多出现几次1；个位1次,十位10次,百位100次

            long diviver = i * 10;  // 台阶大小; 个位的台阶是10,十位的台阶是100,.....

            // (研究商)台阶个数 × 最多出现次数  +      (研究余数)附加个数计算： 余数 > (最多次数 * 2 - 1) = 最多次数   余数 < 最多次数 = 0  其他 = 余数 - i + 1

            //          n / 10 * 1           +      (if(k > 1) 1 else if(k < 1) 0 else k - 1 + 1)
            count += (int) ((n / diviver) * i + Math.min(Math.max(0, n % diviver - i + 1), i));
        }
        return count;
    }
}
