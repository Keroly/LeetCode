/*
    删除链表的节点(n)

题目描述：
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 */

public class J18 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
