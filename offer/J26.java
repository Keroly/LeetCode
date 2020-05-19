/*
    树的子结构

题目描述：
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)  B是A的子结构， 即 A中有出现和B相同的结构和节点值。

 */

public class J26 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public boolean process(TreeNode nodeA, TreeNode nodeB){
        if (nodeB == null) {
            return true;
        }
        if (nodeA == null || nodeA.val != nodeB.val) {
            return false;
        }
        return process(nodeA.left, nodeB.left) && process(nodeA.right, nodeB.right);
    }

    public boolean isSubStructure(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null || nodeB == null){
            return false;
        }
        return process(nodeA, nodeB) || isSubStructure(nodeA.left, nodeB) || isSubStructure(nodeA.right, nodeB);
    }
}
