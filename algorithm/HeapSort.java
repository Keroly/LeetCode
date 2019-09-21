//堆排序   时间复杂度O(N*logN)  额外空间复杂度O(1)
/*
堆结构非常重要
1，堆结构的heapInsert与heapify
2，堆结构的增大和减少
3，如果只是建立堆的过程，时间复杂度为O(N)
4，优先级队列结构，就是堆结构
 */
import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr){
        if (arr.length < 2 || arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
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
            heapSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1,arr2)){
                successd = false;
                break;
            }
        }
        System.out.println(successd ? "nice" : "wrong");

        int[] arr = generateRandomArray(size,value);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}
