/*
    矩形覆盖
题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class B10 {
    public static int sum = 0;
    public static int process(int curr, int target){

        if (curr == target){
            sum += 1;
            return sum;
        }
        if (curr == target - 1){
            sum += 2;
            return sum;
        }
        process(curr + 1, target);
        process(curr + 2, target);
        return sum;
    }

    public static int RectCover(int target) {
        if (target <= 0) return 0;
        return process(1, target);
    }

    public static void main(String[] args) {
        System.out.println(RectCover(2));
    }
}
