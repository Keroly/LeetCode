/*
    字符串的排列
题目描述:
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */


import java.util.ArrayList;
import java.util.Collections;

public class B36 {
    public void  swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void process(ArrayList list, int index, char[] arr){
        if (index == arr.length - 1) list.add(new String(arr));
        for (int i = index; i < arr.length; i++){
            if (i == index || arr[i] != arr[index]){
                swap(arr, i, index);
                process(list, index + 1, arr);
                swap(arr, i, index);
            }
        }
    }


    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) return list;
        process(list, 0, str.toCharArray());
        Collections.sort(list);
        return list;
    }
}
