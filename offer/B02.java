/*
    替换空格

题目描述:
(某个存储结构后面有多余的内存空间，从后往前）
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy，则经过替换之后的字符串为We%20Are%20Happy。
 */

public class B02 {
    public String replaceSpace(StringBuffer str) {
        char[] arr = str.toString().toCharArray();
        int count = 0;

        for (char item: arr) {
            if (item == ' ') {
                count++;
            }
        }

        char[] result = new char[arr.length + count * 2];

        for (int i = arr.length - 1, j = result.length - 1; i >= 0; i--){
            if (arr[i] == ' '){
                result[j--] = '0';
                result[j--] = '2';
                result[j--] = '%';
            }else {
                result[j--] = arr[i];
            }
        }

        return String.valueOf(result);
    }
}

//  时间：O(n) 空间：O(n) || 使用StringBuffer.append()  时间：O(n) 空间：O(1)
