/*
    二叉树的下一个结点
题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class B57 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return pNode;
        TreeLinkNode node = pNode;
        // 在以pNode为根的子树中,没有找到后继,且pNode是根节点
        if (node.right == null && node.next == null) return null;
        // 在以pNode为根的子树中,查找后继结点
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        //  在以pNode为根的子树中,没有找到后继,且pNode不是根节点,pNode是其父的右孩子
        if (node.next.left != node){
            while (node.next != null && node.next.right == node){
                node = node.next;
            }
        }
        return node.next;
    }

}
