/*
    二维数组中的查找

题目描述:
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入一个整数和这样的一个二维数组，判断数组中是否含有该整数。
 */

public class B01 {
    public static boolean Find(int target, int [][] array) {
        int weight = array[0].length; // 几列
        int hight = array.length; // 几行
        int horizontal = 0; // 行号
        int vertical = weight - 1; // 列号
        while (horizontal < hight && vertical >= 0){
            if (array[horizontal][vertical] < target){
                horizontal++;
            }else if (array[horizontal][vertical] > target){
                vertical--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Find(13, array));
    }
}
