/*
    字符串的所有排列

题目描述：
输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 */

import java.util.ArrayList;
import java.util.HashSet;

public class J38 {
    public void swap(char[] s, int i, int j){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
    public void process(char[] s, int index, ArrayList<String> list){
        if (index == s.length - 1) {
            list.add(String.valueOf(s));
            return;
        }
        HashSet<Character> set = new HashSet();
        for (int i = index; i < s.length; i++) {
            if (!set.contains(s[i])){
                set.add(s[i]);
                swap(s, i, index);
                process(s, index + 1, list);
                swap(s, i, index);
            }
        }
    }
    public String[] permutation(String s) {
        ArrayList<String> list = new ArrayList<String>();
        process(s.toCharArray(), 0, list);
        return list.toArray(new String[list.size()]);
    }
}
