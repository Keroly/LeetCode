/*
    有效的括号

题目描述：
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 */

import java.util.Stack;

public class L020 {
    public boolean isValid(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.add(')');
            }else if (s.charAt(i) == '['){
                stack.add(']');
            }else if (s.charAt(i) == '{'){
                stack.add('}');
            }else {
                if (!stack.isEmpty() && stack.pop() == s.charAt(i)){
                    continue;
                }
                return false;
            }
        }

        if (stack.isEmpty()){
            return true;
        }

        return false;
    }
}
