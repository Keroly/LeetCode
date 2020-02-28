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
         if (head == null || k <= 0) return null;
         ListNode start = head;
         ListNode end = head;

         for (int i = 1; i < k; i++){
             end = end.next;
         }

         while (end != null && end.next != null){
             end = end.next;
             start = start.next;
         }

         if (end == null) return end;

         return start;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode( 1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node = FindKthToTail(node,1);
        if (node != null){
            System.out.println(node.val);
        }
    }
}
