/*
    把字符串转换成整数

题目描述: 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
输入描述: 输入一个字符串,包括数字字母符号,可以为空
输出描述: 如果是合法的数值表达则返回该数字，否则返回0
示例1
输入
+2147483647
    1a33
输出
2147483647
    0
 */
public class B51 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0 || str == "+" || str == "-") return 0;
        int limit = -Integer.MAX_VALUE;
        int label = 1;
        int result = 0;
        for (int i = 0; i < str.length(); i++){
            if (i == 0 && ((str.charAt(i) == '-') || str.charAt(i) == '+')){  // 第一位如果是负数,"+"或者"-"
                if (str.charAt(i) == '-'){  // 若是"-",则改变边界条件(limit)和符号位(label)
                    limit = Integer.MIN_VALUE;
                    label = -1;
                }
                continue;
            }else if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){    // 如果是数字,继续分析
                int num = str.charAt(i) - '0';
                int temp = result * 10;
                if (result >= (limit / 10) && temp >= (limit + num) ){  // 关键在这里,见文字分析
                    result = result * 10 - num;
                }else {     // 数值溢出, 返回0
                    return 0;
                }
            }else {     // 如果是非法字符, 返回0
                return 0;
            }
        }
        return label > 0 ? -result: result;
    }

    public static void main(String[] args) {
        System.out.println(new B51().StrToInt("+2147483647"));// -2147483648
    }
}
