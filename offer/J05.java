/*
    替换空格(n)

题目描述：
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 */

public class J05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        int lens = s.length();
        int flag = 0;
        for (int i = 0; i < lens; i++) {
            if (s.charAt(i)== ' '){
                flag++;
            }
        }

        char[] ans = new char[lens + 2 * flag];
        for (int i = ans.length - 1, j = lens - 1; i >= 0 && j >= 0; i--,j--){
            if (s.charAt(j) != ' '){
                ans[i] = s.charAt(j);
            }else {
                ans[i--] = '0';
                ans[i--] = '2';
                ans[i] = '%';
            }
        }
        return String.valueOf(ans);
    }
}
