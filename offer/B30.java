/*
    左旋转字符串
题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class B30 {
    public void swap(char[] arr, int i, int j){
        while (i < j){
            char temp = arr [i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0) return "";
        char[] array = str.toCharArray();
        swap(array, 0, n - 1);
        swap(array, n, array.length - 1);
        swap(array, 0, array.length - 1);
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        System.out.println(new B30().LeftRotateString("abcdefg", 1));
    }
}
