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

    public static ListNode swapPairs(ListNode head) {   // 递归
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

//    public ListNode swapPairs(ListNode head) {   // 非递归
//        ListNode pre = new ListNode(0);
//        pre.next = head;
//        ListNode temp = pre;
//        while(temp.next != null && temp.next.next != null) {
//            ListNode start = temp.next;
//            ListNode end = temp.next.next;
//            temp.next = end;
//            start.next = end.next;
//            end.next = start;
//            temp = start;
//        }
//        return pre.next;
//    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node = swapPairs(node);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
