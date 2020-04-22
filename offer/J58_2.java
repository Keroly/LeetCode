/*
    左旋转字符串(n)

题目描述：
输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"

 */

public class J58_2 {
    public void swap(char[] arr, int i, int j){
        while (i < j){
            char temp = arr [i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public String reverseLeftWords(String s, int n) {
        char[] arr = s.toCharArray();
        swap(arr, 0, n - 1);
        swap(arr, n, s.length() - 1);
        swap(arr, 0, s.length() - 1);
        return String.valueOf(arr);
    }
}
