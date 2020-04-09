/*
    把数组排成最小的数

题目描述：
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class B40 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0) return "";
        String result = "";
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                String x = numbers[i] + "" + numbers[j];
                String y = numbers[j] + "" + numbers[i];
                if (x.compareTo(y) > 0) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for (int num: numbers) {
            result += num;
        }
        return result;
    }
}
