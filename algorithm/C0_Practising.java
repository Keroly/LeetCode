public class C0_Practising {

    public static void sort(int[] arr,int l, int r){

        if(arr.length < 2 || arr == null){
            return;
        }

        mergesort(arr,l,r);
    }

    public static void  mergesort(int[] arr,int l,int r){
        if(l == r) return;
        int mid = l + ((r - l) >> 1);
        mergesort(arr,l,mid);
        mergesort(arr,mid + 1,r);
        outSort(arr,l,mid,r);
    }

    private static void outSort(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <=r){
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid){
            help[i++] = arr [p1++];
        }
        while (p2 <= r){
            help[i++] = arr [p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l + i] = help[i];
        }
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{21,37,6,25,19,18,20,30};
        sort(arr,0,arr.length-1);
        for (int x:arr) {
            System.out.print(x + " ");
        }
    }
}
