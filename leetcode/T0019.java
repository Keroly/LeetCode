/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
*/

public class T0019 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        head = start;
        ListNode node = start;
        while (n > 0){
            node = node.next;
            n--;
        }
        while (node.next != null){
            start = start.next;
            node = node.next;
        }
        start.next = start.next.next;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node = removeNthFromEnd(node,2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
