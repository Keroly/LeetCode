import sun.plugin.javascript.navig.LinkArray;

import java.util.Stack;

/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class T0024 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = head.next;
        ListNode start = head;
        ListNode first = null;
        ListNode help = null;
        while (start != null && start.next != null){
            first = start;
            start = start.next.next;
            first.next.next = first;
            if(start != null && start.next != null)
                first.next = start.next;
            else
                first.next = start;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node = null;

        node = swapPairs(node);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
