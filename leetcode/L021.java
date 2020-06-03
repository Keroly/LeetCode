/*
    合并两个有序链表

题目描述:
将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 */
public class L021 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;

        if (l1 == null || l2 == null) {
            return l1 == result ? l2 : l1;
        }

        if (l1.val < l2.val){
            result = l1;
            l1 = l1.next;
        }else {
            result = l2;
            l2 = l2.next;
        }

        ListNode cur = result;
        cur.next =null;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return result;
    }
}
