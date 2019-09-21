//插入排序  时间复杂度O(N^2) 额外空间复杂度O(1)

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr){
        if (arr.length < 2 || arr == null){
            return;
        }
        for (int i = 1 ;i < arr.length; i++){
            for (int j = i - 1; j >=0 && arr[j+1] < arr[j] ; j--){
                swap(arr,j,j+1);
            }

        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 绝对正确的方法
    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
    }

    // 随机数发生器
    public static int[] generateRandomArray(int size, int value){
        // Math.random() -> double [0,1)
        // (int)((size + 1) * Math.random()) -> [0,size] 整数
        // size = 6  size + 1 = 7
        // Math.random() -> [0,1) * 7 ->[0,7) double
        // double -> int [0,6] -> int
        int[] arr = new int[(int) ((size + 1 ) * Math.random())];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)((value +1 ) * Math.random()) - (int)(value * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if (arr1 == null && arr2 == null){
            return true;
        }
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 10;
        int size = 100;
        int value = 100;
        boolean successd = true;
        for (int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(size,value);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1,arr2)){
                successd = false;
                break;
            }
        }
        System.out.println(successd ? "nice" : "wrong");

        int[] arr = generateRandomArray(size,value);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }
}
