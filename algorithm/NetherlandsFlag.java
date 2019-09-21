// 给定一个数组,以该数组的最后一个数字temp为标准,把数组划分为三部分：小于temp 等于temp 大于temp

public class NetherlandsFlag {

    public static int[] partition(int[] arr, int l, int r){ // 国旗问题 用最后一个数字作为划分标准
        int less = l - 1;
        int more = r + 1;
        int p = l;
        int temp = arr[r];
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

        int[] arr = {0,9,4,6,2,1,1,6};
        printArray(arr);
        int[] index = partition(arr,0,arr.length-1);
        printArray(arr);
        System.out.println("等于区的左边界："+index[0]);
        System.out.println("等于区的右边界："+index[1]);
    }
}
