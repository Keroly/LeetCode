/*
    电话号码的字母组合

题目描述：
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 */

import java.util.ArrayList;
import java.util.List;

public class L017 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.equals("")) {
            return res;
        }

        res.add("");

        String[] chars = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i ++) {

            String element = chars[digits.charAt(i) - '2'];
            List<String> cur = new ArrayList<>();

            for (int k = 0; k < element.length(); k++) {
                for (int j = 0; j < res.size(); j++) {
                    String str = res.get(j) + element.charAt(k) + "";
                    cur.add(str);
                }
            }

            res = cur;
        }

        return res;
    }
}
