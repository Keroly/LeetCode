import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr){
        if (arr.length < 2 || arr == null){
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int L, int R){
        if (L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++){
            arr[l + i] = help[i];
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
            mergeSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1,arr2)){
                successd = false;
                break;
            }
        }
        System.out.println(successd ? "nice" : "wrong");

        int[] arr = generateRandomArray(size,value);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
}
