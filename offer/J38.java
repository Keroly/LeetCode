/*
    字符串的所有排列

题目描述：
输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 */

import java.util.HashSet;
import java.util.LinkedList;

public class J38 {
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public String[] permutation(String s) {
        if (s == null || s == "") {
            return new String[0];
        }
        LinkedList<String> list = new LinkedList<>();
        char[] chs = s.toCharArray();
        dfs(list, chs, 0);
        int size = list.size();
        String[] ans = new String[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.poll();
        }
        return ans;
    }

    private void dfs(LinkedList<String> list, char[] chs, int num) {
        if (num == chs.length - 1) {
            list.add(String.valueOf(chs));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = num; i < chs.length; i++) {
            if (!set.contains(chs[i])) {
                set.add(chs[i]);
                swap(chs, num, i);
                dfs(list, chs, num + 1);
                swap(chs, num, i);
            }
        }
    }
}
