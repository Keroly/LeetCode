/*
    左旋转字符串
题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class B30 {
    public static void swap(char[] arr, int i, int j){
        char temp = arr [i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String LeftRotateString(String str,int n) {
        char[] arr = str.toCharArray();
        if (n > arr.length) return str;
        for (int i = 0; i < n; i++) {
            if (i < n - i - 1){
                swap(arr, i, n - i - 1);
            }
        }

        for (int j = n; j < arr.length; j++){
            if (j < arr.length - 1 + n - j) {
                swap(arr, j, arr.length - 1 + n - j);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 - i){
                swap(arr, i, arr.length - 1 - i);
            }
        }

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcdefg", 1));
    }
}
