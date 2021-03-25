/*
    两个链表的第一个公共节点(n + m)

题目描述：
输入两个链表，找出它们的第一个公共结点

注意：
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

 */

public class J52 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lens_A = 0;
        int lens_B = 0;
        ListNode flag_A = headA;
        ListNode flag_B = headB;
        while (flag_A != null) {
            lens_A++;
            flag_A = flag_A.next;
        }
        while (flag_B != null) {
            lens_B++;
            flag_B = flag_B.next;
        }

        flag_A = headA;
        flag_B = headB;
        int gap = lens_A - lens_B;

        if (lens_B > lens_A) {
            flag_A = headB;
            flag_B = headA;
            gap = lens_B - lens_A;
        }

        for (int i = 0; i < gap; i++) {
            flag_A = flag_A.next;
        }
        while (flag_A != null) {
            if (flag_A == flag_B) {
                return flag_A;
            }
            flag_A = flag_A.next;
            flag_B = flag_B.next;
        }

        return null;
    }
}
