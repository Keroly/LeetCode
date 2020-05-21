/*
    构建乘积数组

题目描述：
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

 */

public class J66 {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        if (a.length == 0) {
            return res;
        }
        int[] nums1 = new int[a.length];
        int[] nums2 = new int[a.length];
        nums1[0] = 1;
        nums2[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++){
            nums1[i] = nums1[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--){
            nums2[i] = nums2[i + 1] * a[i + 1];
        }
        for(int i = 0; i < a.length; i++){
            res[i] = nums1[i] * nums2[i];
        }
        return res;
    }
}
