/*
    合并两个有序数组

题目描述：
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。

说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */

public class L088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[cur--] = nums1[i--];
            }else {
                nums1[cur--] = nums2[j--];
            }
        }

        while (i >= 0){
            nums1[cur--] = nums1[i--];
        }

        while (j >= 0){
            nums1[cur--] = nums2[j--];
        }
    }
}
