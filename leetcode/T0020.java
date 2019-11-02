/*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。有
    有效字符串需满足：
    1.左括号必须用相同类型的右括号闭合。
    2.左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:
    输入: "()[]{}"
    输出: true

    示例 2:
    输入: "("
    输出: false

    示例 3:
    输入: "{[]}"
    输出: true
*/

import java.util.Stack;

public class T0020 {

    public static boolean isRight(String str){
        if(str == ""){
            return true;
        }
        char[] ch = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++){
            if (stack.isEmpty()){
                if (ch[i]==')' || ch[i]=='}' || ch[i]==']'){
                    return false;
                }
                stack.push(ch[i]);
            }else {
                if (ch[i]=='(' || ch[i]=='{' || ch[i]=='['){
                    stack.push(ch[i]);
                }else {
                    if(isMatch(stack.peek(),ch[i])){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isMatch(char ch1, char ch2){
        switch (ch1){
            case '[':
                if (ch2 == ']'){
                    return true;
                }else {
                    return false;
                }
            case '(':
                if (ch2 == ')'){
                    return true;
                }else {
                    return false;
                }
            case '{':
                if (ch2 == '}'){
                    return true;
                }else {
                    return false;
                }
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        String str = "{";
        int x = isRight(str) ? 1 : 0;
        System.out.println(x);
    }
}
