/*
    环形链表2
题目描述：
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 */
public class L142 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast && fast != null){
            slow = slow.next;
            if (fast.next == null) break;
            fast = fast.next.next;
        }
        if (slow == fast) {
            slow = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}
