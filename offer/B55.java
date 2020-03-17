/*
    链表中环的入口结点
题目描述
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class B55 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        int nums = 1;

        while (slow != null && fast != null){   // 判断是否有环
            if (slow == fast) break;
            if (fast.next == null) {
                fast = null;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == null || fast == null) return null;  // 无环

        slow = pHead;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
