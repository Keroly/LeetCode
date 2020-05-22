/*
    二叉搜索树与双向链表

题目描述：
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。

 */

import java.util.Stack;

public class J36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack  = new Stack<Node>();
        Node cur = root;
        Node pre = null;
        Node head = root;
        Node end = root;
        while (head.left != null) {
            head = head.left;
        }
        while (end.right != null) {
            end = end.right;
        }
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                Node node = stack.pop();
                node.left = pre;
                if (pre != null) {
                    pre.right = node;
                }
                cur = node.right;
                pre = node;
            }
        }
        head.left = end;
        end.right = head;
        return head;
    }

}
