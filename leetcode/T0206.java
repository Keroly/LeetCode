/*
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

public class T0206 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    static ListNode start = null;
    public static ListNode process(ListNode node){
        if (node.next == null){
            start = node;
            return node;
        }
        process(node.next).next = node;
        return node;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        process(head);
        head.next = null;
        return start;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node = reverseList(node);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
