/*
    对链表进行插入排序

题目描述：
对链表进行插入排序。
 */

public class L147 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = new ListNode(-1);
        ListNode root = head.next;
        node.next = head;
        head.next = null;
        while (root != null){
           ListNode cur = root;
           root = root.next;
           ListNode flag = node;

           while (flag.next != null){
               if (flag.next.val > cur.val){
                   cur.next = flag.next;
                   flag.next = cur;
                   break;
               }else {
                   flag = flag.next;
               }
           }

           if (flag.next == null){
               flag.next = cur;
               cur.next = null;
           }
        }
        return node.next;
    }
}
