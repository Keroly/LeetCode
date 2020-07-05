/*
    从尾到头打印链表(n)

题目描述：
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 */

public class J06 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode root = new ListNode(0);
        ListNode temp = null;
        int count = 0;

        while (cur != null) {
            count++;
            temp = cur;
            cur = cur.next;
            temp.next = root.next;
            root.next = temp;
        }

        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = root.next.val;
            root = root.next;
        }

        return res;
    }
}
