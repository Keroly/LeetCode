/*
    第一个只出现一次的字符
题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */

import java.util.HashMap;

public class B42 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        char[] array = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        for (char item: array) {
            if (map.containsKey(item)){
                map.put(item, map.get(item) + 1);
            }else {
                map.put(item, 1);
            }
        }
        for (int i = 0; i < array.length; i++){
            if (map.get(array[i]) == 1) return i;
        }
        return -1;
    }
}
