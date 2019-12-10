/*
    构建乘积矩阵
题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class B16 {
    public static int[] multiply(int[] A) { // 时间复杂度O(n) 空间复杂度O(n)
        if (A.length == 0) return A;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 1;
        right[A.length - 1] = 1;
        for (int i = 1; i < A.length; i++) {
            left[i] = left[i - 1] * A[i - 1];
            right[A.length - 1 - i] = right[A.length - i] * A[A.length - i];
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = left[i] * right[i];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        arr = multiply(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
