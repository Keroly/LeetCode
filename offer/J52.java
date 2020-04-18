/*
    两个链表的第一个公共节点

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
        if (headA != null && headB != null) {
            int headALens = 0;
            int headBLens = 0;
            int abs = 0;
            ListNode p_headA = headA;
            ListNode p_headB = headB;
            ListNode p_longest = headA;
            ListNode p_shortest = headB;

            while(p_headA != null){
                headALens++;
                p_headA = p_headA.next;
            }
            while(p_headB != null){
                headBLens++;
                p_headB = p_headB.next;
            }

            if(headALens < headBLens){
                p_longest = headB;
                p_shortest = headA;
            }

            abs = Math.abs(headALens - headBLens);
            for(int i = 0; i < abs; i++){
                p_longest = p_longest.next;
            }

            while(p_longest != null && p_shortest != null){
                if(p_longest == p_shortest){
                    return p_longest;
                }
                p_longest = p_longest.next;
                p_shortest = p_shortest.next;
            }
        }
        return null;
    }
}
