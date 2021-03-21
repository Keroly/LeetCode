/*
    反转链表(n)

题目描述：
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 */

public class J24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
            ListNode temp = node;
            node = node.next;
            temp.next = head;
            head = node;
        }
        return head;
    }
}
