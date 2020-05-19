/*
    反转链表(n)

题目描述：
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

 */

public class J24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode root = new ListNode(-1);
        ListNode cur = head;
        while (head != null){
            cur = head.next;
            head.next = root.next;
            root.next = head;
            head = cur;
        }
        return root.next;
    }
}
