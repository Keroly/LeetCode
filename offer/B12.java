/*
    链表中倒数第k个节点

题目描述：
输入一个链表，输出该链表中倒数第k个结点。
 */

public class B12 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;
        if (k <= 0) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && --k > 0){
            fast = fast.next;
        }

        if (fast == null){
            return null;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
