/*
    无重复字符的最长子串

题目描述：
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 */

import java.util.HashMap;
import java.util.Map;

public class L003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)) + 1 , start); // 如果重复位置大于start则需要更新start,若小于则不用
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
