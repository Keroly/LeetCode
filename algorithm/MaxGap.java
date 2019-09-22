// 给定一个数组,要求计算出该数组排序后,相邻两数字的最大差值

public class MaxGap {

    // only for 0~200 value
    public static void MaxGap(int[] arr){
        if (arr.length < 2 || arr == null){
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++){
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0;j < bucket.length; j++){
            while (bucket[j]-- > 0){
                arr[i++] = j;
            }
        }
    }


    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

        int[] arr = {0,200,24,68,21,3,6,9,72,6,3,2,24,87,36,7,12,125,3,57,158};
        printArray(arr);
        MaxGap(arr);
        printArray(arr);
    }
}
