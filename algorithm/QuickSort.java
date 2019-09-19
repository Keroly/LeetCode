import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr){
        if (arr.length < 2 || arr == null){
            return;
        }
        sortProcess(arr,0,arr.length-1);
    }

    private static void sortProcess(int[] arr, int l, int r) {
        if (l < r) {
            int[] index = partition(arr,l,r);
            sortProcess(arr,l,index[0] - 1);
            sortProcess(arr,index[1] + 1,r);
        }
    }

    public static int[] partition(int[] arr, int l, int r){
        int less = l - 1;
        int more = r + 1;
        int p = l;
        int temp = arr[l + (int)(Math.random() * (r - l + 1))];
        while(p < more){
            if (arr[p] < temp){
                swap(arr,++less,p++);
            }else if (arr[p] > temp){
                swap(arr,--more,p);
            }else {
                p++;
            }
        }

        return new int[] {less + 1, more - 1};
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
            quickSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1,arr2)){
                successd = false;
                break;
            }
        }
        System.out.println(successd ? "nice" : "wrong");

        int[] arr = generateRandomArray(size,value);
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
