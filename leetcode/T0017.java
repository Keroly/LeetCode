/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T0017 {
    static List list = new ArrayList<>();
    static Map<String, String> map = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public static void process(String result, String digits){
        if (digits.length() == 0) {
            list.add(result);
            return;
        }
        String digit = digits.substring(0,1);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            process(result + letters.substring(i, i + 1), digits.substring(1));
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return list;
        process("",digits);
        return list;
    }
    public static void main(String[] args) {
        String str = "";
        list = letterCombinations(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
