/*
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

public class T0206 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) { // 迭代 O(N) O(1)
        if (head == null || head.next == null) return head;
        ListNode temp = null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node = reverseList(node);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
