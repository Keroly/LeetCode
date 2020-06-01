/*
    两数相加

题目描述：
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 */

public class L002 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
   }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        int flag = 0;

        while (l1 != null || l2 != null){
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + flag;
            int num = sum % 10;
            flag = sum / 10;
            cur.next = new ListNode(num);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (flag == 1){
            cur.next = new ListNode(1);
        }

        return result.next;
    }
}
