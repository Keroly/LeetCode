/*
    孩子们的游戏
题目描述
首先,让小朋友们n围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
直到剩下最后一个小朋友,哪个小朋友会得到最后这份礼品呢？(注：小朋友的编号是从0到n-1)
如果没有小朋友，请返回-1
 */


import java.util.ArrayList;

public class B32 {
    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1) return -1;
        int cur = -1;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        while (list.size() != 1){
            for (int i = 0; i < m; i++) {
                cur++;
                if (cur == list.size()){
                    cur = 0;
                }
            }
            list.remove(cur--);
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(2, 3));
    }
}
