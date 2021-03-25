/*
    第一个只出现一次的字符(n)

题目描述：
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。

 */


import java.util.HashMap;

public class J50 {
    public char firstUniqChar(String s) {
        char[] chs = s.toCharArray();
        int[] all = new int[256];
        for (Character element: chs) {
            all[element]++;
        }
        for (Character element: chs) {
            if (all[element] == 1) {
                return element;
            }
        }
        return ' ';
    }
}
