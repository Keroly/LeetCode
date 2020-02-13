/*
    替换空格
题目描述:(某个存储结构后面有多余的内存空间，从后往前）
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy，则经过替换之后的字符串为We%20Are%20Happy。
 */
public class B02 {
    public static String replaceSpace(StringBuffer str) {
        char[] arr = str.toString().toCharArray();
        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--){
            if (arr[i] == ' '){
                count++;
            }
        }

        char[] arr_new = new char[arr.length + 2 * count];

        for (int i = arr.length - 1, j = arr.length + 2 * count - 1; i >= 0 && j >= 0; i--, j--){
            if (arr[i] == ' '){
                arr_new[j--] = '0';
                arr_new[j--] = '2';
                arr_new[j] = '%';
            }else {
                arr_new[j] = arr[i];
            }
        }

        return String.valueOf(arr_new);
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("we are happy");
        System.out.println(replaceSpace(str));
    }
}
