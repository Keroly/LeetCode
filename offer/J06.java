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
        ListNode node = new ListNode(0);
        ListNode cur = head;
        int nums = 0;
        while (cur != null) {
            nums++;
            ListNode temp = cur.next;
            cur.next = node.next;
            node.next = cur;
            cur = temp;
        }
        int[] res = new int[nums];
        for (int i = 0; i < nums; i++) {
            res[i] = node.next.val;
            node = node.next;
        }
        return res;
    }
}
