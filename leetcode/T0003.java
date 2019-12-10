/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

import java.util.HashMap;
public class T0003 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == "") return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        char[] arr = s.toCharArray();
        int res = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                j =  Math.max(map.get(arr[i]) + 1 , j) ;
            }
            res = res > i - j + 1 ? res : i - j + 1;
            map.put(arr[i],i);
        }
        return res > arr.length - j ? res : arr.length -j;
    }

    public static void main(String[] args) {
        String str = "abb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}