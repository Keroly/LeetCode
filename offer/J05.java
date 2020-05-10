/*
    替换空格(n)

题目描述：
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 */

public class J05 {
    public String replaceSpace(String s) {
        char[] str = s.toCharArray();
        int nums = 0;
        for (char element : str) {
            if (element == ' '){
                nums++;
            }
        }
        char[] res = new char[str.length + nums * 2];
        for (int i = res.length - 1, j = str.length - 1; i >= 0 && j >= 0; i-- , j--){
            if (str[j] != ' '){
                res[i] = str[j];
            }else {
                res[i--] = '0';
                res[i--] = '2';
                res[i] = '%';
            }
        }
        return String.valueOf(res);
    }
}
