/*
    翻转单词顺序(n)

题目描述：
输入字符串"I am a student. "，则输出"student. a am I"

说明：
无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

 */

public class J58_1 {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] str = s.split(" ");
        for (int i = str.length - 1; i >= 0; i--){
            if  (!str[i].equals("")){
                result.append(str[i] + " ");
            }
        }
        return result.toString().trim();
    }
}
