/*
    第一个只出现一次的字符(n)

题目描述：
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。

 */

public class J50 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[]count = new int[256];
        for (char element : chars){
            count[element]++;
        }
        for (char element : chars){
            if (count[element] == 1){
                return element;
            }
        }
        return ' ';
    }
}
