/*
    合并两个排序的链表(n)

题目描述：
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

 */

public class J25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1;
        l1 = l1.next;
        if (l2.val < head.val) {
            l1 = head;
            head = l2;
            l2 = l2.next;
        }
        ListNode root = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return root;
    }
}
