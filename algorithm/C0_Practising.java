public class C0_Practising {

    public static int[] partition(int[] arr,int l, int r){

        int less = l - 1;
        int more = r;

        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr, ++less, l++); // 这里的 ++  很有必要
            }else if (arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[] {less + 1, more};
    }

    public static void sort(int[] arr, int l, int r){
        if(l < r){
            int standard_index = l + (int)(Math.random() * (r - l + 1));
            swap(arr, standard_index, r);
            int result[] = partition(arr,l,r);
            sort(arr, l, result[0] - 1);
            sort(arr, result[0] + 1,r);
        }
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{21,37,6,25,19,18,20,30};
        sort(arr, 0, arr.length - 1);
        for (int x:arr) {
            System.out.print(x + " ");
        }
    }
}
