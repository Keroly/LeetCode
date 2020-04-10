/*
    柱状图中的最大矩形

题目描述:
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */

public class L084 {
    public int process(int[] height, int start, int end) {
        if (start > end) return 0;
        int miniIndex = start;
        boolean sorted = true;
        for (int i = start + 1; i <= end; i++){
            if (height[i] < height[i - 1]){
                sorted = false;
            }
            if (height[miniIndex] > height[i]){
                miniIndex = i;
            }
        }
        if (sorted){
            int result = 0;
            for (int i = start; i <= end; i++){
                result = Math.max(result, (end - i + 1) * height[i]);
            }
            return result;
        }
        return Math.max(height[miniIndex] * (end - start + 1), Math.max(process(height, start, miniIndex - 1), process(height, miniIndex + 1, end)));
    }

    public int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
        return process(height, 0, height.length - 1);
    }

    public static void main(String[] args) {
        System.out.printf("" + new L084().largestRectangleArea(new int[]{0, 2, 0}));
    }

}
