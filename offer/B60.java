/*
    把二叉树打印成多行
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        for (int i = 0; queue.size() != 0; i++){
            result.add(new ArrayList<Integer>());
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                result.get(i).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }
}
