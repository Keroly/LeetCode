/*
    最长不含重复字符的子字符串

题目描述：
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

 */

import java.util.HashMap;

public class J48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int res = 1;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        map.put(str[0], 0);
        for (int i = 1; i < str.length; i++) {
            if (map.containsKey(str[i]) && map.get(str[i]) >= start) {
                res = Math.max(res, i - start);
                start = map.get(str[i]) + 1;
            }
            map.put(str[i], i);
        }
        res = Math.max(res, str.length - start);
        return res;
    }

}
