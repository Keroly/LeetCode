/*
    回文链表
题目描述：
请判断一个链表是否为回文链表。 时间：O(n) 空间：O(1)
 */

public class L234 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head_2 = slow.next;
        slow.next = null;

        ListNode pre = null;
        ListNode cur = head_2;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        while (pre != null && head != null){
            if (pre.val != head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }

        return true;
    }
}
