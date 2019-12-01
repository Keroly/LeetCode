/*
    链表中倒数第k个节点
题目描述
输入一个链表，输出该链表中倒数第k个结点。
 */
public class B12 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || head.next == null) return head;
        if (k <= 0) return null;
        ListNode node;
        ListNode start = head;
        ListNode end = head;
        while (k-- > 1){
            end = end.next;
            if (end == null) return null;
        }
        while (end.next != null){
            start = start.next;
            end = end.next;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode( 1);
        node.next = new ListNode(2);
        node = FindKthToTail(node,3);
        System.out.println(node.val);
    }
}
