/*
    环形链表
题目描述：
给定一个链表，判断链表中是否有环。
 */

public class L141 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast && fast != null){
            slow = slow.next;
            if (fast.next == null) break;
            fast = fast.next.next;
        }
        if (slow == fast) {
            return true;
        }
        return false;
    }
}
