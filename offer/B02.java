/*
    替换空格
题目描述:(从后往前）
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy，则经过替换之后的字符串为We%20Are%20Happy。
 */
public class B02 {
    public static String replaceSpace(StringBuffer str) {
        char[] array = str.toString().toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' '){
                count++;
            }
        }
        char[] result = new char[array.length + 2 * count];
        for (int i = array.length - 1, j = array.length + 2 * count - 1; i >= 0 && j >= 0; i--,j--) {
            if (array[i] != ' '){
                result[j] = array[i];
            }else {
                result[j--] = '0';
                result[j--] = '2';
                result[j] = '%';
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("we are happy");
        System.out.println(replaceSpace(str));
    }
}
