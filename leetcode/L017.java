/*
    电话号码的字母组合

题目描述：
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L017 {
    HashMap<String, String> map = new HashMap<String, String>(){
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};

    List<String> list = new ArrayList<>();

    public void process(String combin, String digits){
        if (digits.equals("")){
            list.add(combin);
            return;
        }
        String letter = map.get(digits.substring(0, 1));
        for (int j = 0; j < letter.length(); j++){
            String next_combin = combin + letter.substring(j, j + 1);
            String next_digits = digits.substring(1);
            process(next_combin, next_digits);
        }
    }


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) return list;
        process("", digits);
        return list;
    }
}
