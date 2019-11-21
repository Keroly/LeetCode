/*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 */
public class T0092 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//    public static ListNode reverseBetween(ListNode head, int m, int n) {
//
//    }
//
//    public static void main(String[] args) {
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        node = reverseBetween(node);
//        while (node != null){
//            System.out.println(node.val);
//            node = node.next;
//        }
//    }
}
