/*
    正则表达式匹配
题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class B52 {
    public boolean process(char[] str, int strIndex, char[] pattern, int patternIndex){
        // 同时结束
        if (str.length == strIndex && pattern.length == patternIndex) return true;
        // 字符串没有结束,但是模式串结束
        if (str.length != strIndex && pattern.length == patternIndex) return false;

        if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
            if (str.length != strIndex && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')){
                // 位置是第一种正常,且位置上的字母匹配
                return process(str, strIndex, pattern, patternIndex + 2)    // '*' 0次
                        || process(str, strIndex + 1, pattern, patternIndex)    // '*' n次
                        || process(str, strIndex + 1, pattern, patternIndex + 2);   // '*' 1次
            }else {
                // 位置是第一种正常,但是位置上的字母不匹配 ||　位置不正常：字符串已经结束，但是模式串没结束，且模式串接下来是 ?*
                return process(str, strIndex, pattern ,patternIndex + 2);   // '*' 0次
            }
        }

        if (str.length != strIndex && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')){
            //　位置是第二种正常,且位置上的字母匹配 || 位置不正常：字符串和模式串都到了最后一位，且位置上的字母匹配
            return process(str, strIndex + 1, pattern, patternIndex + 1);
        }

        //　位置是第二种正常,但位置上的字母不匹配
        //  位置不正常：字符串和模式串都到了最后一位，但位置上的字母不匹配
        return false;
    }

    public boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null) return false;
        return process(str, 0, pattern, 0);
    }
}
