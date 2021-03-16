/*
    替换空格(n)

题目描述：
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 */

public class J05 {
    public String replaceSpace(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        char[] chs = s.toCharArray();
        int clk = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                clk++;
            }
        }
        char[] ans = new char[chs.length + 2 * clk];
        for (int i = chs.length - 1, flag = ans.length - 1; i >= 0; i--, flag--) {
            if (chs[i] == ' '){
                ans[flag--] = '0';
                ans[flag--] = '2';
                ans[flag] = '%';
            }else {
                ans[flag] = chs[i];
            }
        }
        return String.valueOf(ans);
    }
}
