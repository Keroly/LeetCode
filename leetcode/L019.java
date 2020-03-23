/*
    删除链表的倒数第N个节点
题目描述：
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class L019 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) return null;
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode left = result;
        ListNode right = result;

        while (n-- > 0 && right != null){
            right = right.next;
        }

        if (right == null) return null;

        while (right.next != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return result.next;
    }
}
