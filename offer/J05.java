/*
    替换空格(n)

题目描述：
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 */

public class J05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int lens = s.length();
        int count = 0;
        for (int i = 0; i < lens; i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
        }

        char[] element = new char[lens + count * 2];
        int index = lens + count * 2;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                element[--index] = '0';
                element[--index] = '2';
                element[--index] = '%';
            }else {
                element[--index] = s.charAt(i);
            }
        }

        return String.valueOf(element);
    }
}
