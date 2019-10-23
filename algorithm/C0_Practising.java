import java.util.Arrays;

public class C0_Practising {

    public static int bucket(long num, long len, long min, long max){
        return (int)((num - min) * len / (max - min));
    }

    public static int maxGap(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        if (min == max) return 0;

        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            index = bucket(nums[i],len,min,max);
            maxs[index] = hasNum[index] ? Math.max(maxs[index],nums[i]):nums[i];
            mins[index] = hasNum[index] ? Math.min(mins[index],nums[i]):nums[i];
            hasNum[index] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < len + 1; i++) {
            if (hasNum[i]){
                res = Math.max(mins[i] - lastMax , res);
                lastMax = maxs[i];
            }
        }

        return res;
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{21,37,6,25,19,18,20,27};

        for (int x:arr) {
            System.out.print(x + " ");
        }

        System.out.println("");
        System.out.println(maxGap(arr));
    }
}
