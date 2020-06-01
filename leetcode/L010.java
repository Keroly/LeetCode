/*
    正则表达式匹配

题目描述：
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素

 */

public class L010 {
    public boolean process(String s1, int i, String s2, int j){
        if (s1.length() == i && s2.length() == j) return true;
        if (s1.length() != i && s2.length() == j) return false;

        if (j + 1 < s2.length() && s2.charAt(j + 1) == '*'){
            if (s1.length() != i && (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.')){
                return process(s1, i, s2, j + 2) || process(s1, i + 1, s2, j) || process(s1, i + 1, s2, j + 2);
            }else {
                return process(s1, i, s2, j + 2);
            }
        }

        if (s1.length() != i && (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '.')){
            return process(s1, i + 1, s2, j+ 1);
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return process(s, 0, p, 0);
    }
}
