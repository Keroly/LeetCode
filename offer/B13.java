/*
    反转链表

题目描述：
输入一个链表，反转链表后，输出新链表的表头。
 */

public class B13 {
    public  class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
//----------------------------------------------  递归  -----------------------------------------------------------------
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
//----------------------------------------------  非递归  ---------------------------------------------------------------
    public ListNode ReverseList_2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        return pre;
    }
}
