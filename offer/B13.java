/*
    反转链表
题目描述
输入一个链表，反转链表后，输出新链表的表头。
 */
public class B13 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode node;

    public static ListNode process(ListNode head){
        if (head == null || head.next == null) {
            if (head.next == null){
                node = head;
                return head;
            }
        }
        process(head.next).next = head;
        head.next.next = head;
        head.next = null;
        return head;
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        process(head);
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(3);
        node1 = ReverseList(node1);
        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}
