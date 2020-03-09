/*
    数字在排序数组中出现的次数
题目描述
统计一个数字在排序数组中出现的次数。
 */

public class B27 {
    public int getLower(int [] array , double target, int i, int j){
        if (i <= j){
            int mid = (i + j) >> 1;
            if (array[mid] < target){
                return getLower(array, target, mid + 1, j); // 前半段
            }else if (array[mid] > target){
                return getLower(array, target, i, mid - 1); // 后半段
            }else {
                if (mid == 0 || (mid != 0 && array[mid - 1] != target)){    // 判断是不是第一个target
                    return mid;
                }
                return getLower(array, target, i, mid - 1);
            }
        }
        return -1;
    }

    public int getHigher(int [] array , double target, int i, int j){
        if (i <= j){
            int mid = (i + j) >> 1;
            if (array[mid] < target){
                return getHigher(array, target, mid + 1, j);
            }else if (array[mid] > target){
                return getHigher(array, target, i, mid - 1);
            }else {
                if (mid == array.length - 1 || (mid != array.length - 1 && array[mid + 1] != target)){
                    return mid;
                }
                return getHigher(array, target, mid + 1, j);
            }
        }
        return -1;
    }

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        int low = getLower(array, k, 0, array.length - 1);
        int high = getHigher(array, k, 0, array.length - 1);
        if (low != -1 && high != -1){
            return (high - low + 1);
        }
        return 0;
    }
}
