/*
    翻转单词顺序列
题目描述
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”
 */
public class B48 {
    public void swap(char[] arr, int i, int j){
        while (i < j){
            char temp = arr [i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return "";
        char[] array = str.toCharArray();
        swap(array, 0, array.length - 1);
        int help = 0;
        for (int i = 0; i <= array.length; i++){
            if (i != array.length && array[i] != ' ') continue;
            swap(array, help, i - 1);
            help = i + 1;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        System.out.println(new B48().ReverseSentence("ac abc abcd"));
    }
}
