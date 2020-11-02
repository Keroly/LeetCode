/*
    链表中倒数第k个节点(n)

题目描述：
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

 */

public class J22 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        for (int i = k; i > 1; i--) {
            cur = cur.next;
            if (cur == null) {
                return null;
            }
        }
        while(cur.next != null) {
            cur = cur.next;
            head = head.next;
        }
        return head;
    }
}
