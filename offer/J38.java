/*
    字符串的所有排列

题目描述：
输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 */

import java.util.ArrayList;
import java.util.HashSet;

public class J38 {
    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void dfs(char[] arr, int index, ArrayList<String> res) {
        if (index == arr.length - 1) {
            res.add(new String(arr));
            return;
        }
        HashSet set = new HashSet();
        for (int i = index; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                swap(arr, i, index);
                dfs(arr, index + 1, res);
                swap(arr, i, index);
            }
        }
    }
    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        ArrayList<String> res = new ArrayList<String>();
        dfs(arr, 0, res);
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
