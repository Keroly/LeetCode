/*
    相交链表
题目描述：
找到两个单链表相交的起始节点。
 */
public class L160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lensA = 0;
        int lensB = 0;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null){
            curA = curA.next;
            lensA++;
        }
        while (curB != null){
            curB = curB.next;
            lensB++;
        }

        curA = lensA > lensB ? headA : headB;
        curB = lensA > lensB ? headB : headA;

        int count = Math.abs(lensA - lensB);
        while (count-- > 0){
            curA = curA.next;
        }

        while (curA != curB && curA != null){
            curA = curA.next;
            curB = curB.next;
        }

        if (curA == curB){
            return curA;
        }

        return null;
    }
}
