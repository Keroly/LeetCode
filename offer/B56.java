/*
    删除链表中重复的结点
题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */

public class B56 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null) return null;
        ListNode node = new ListNode(0);
        ListNode cur = pHead;
        ListNode tag = node;
        node.next = pHead;

        while (cur != null){
            if ((cur.next != null && cur.val != cur.next.val) || cur.next == null){  // 不重复的节点 或者 最后一个结点
                tag.next = cur;
                tag = tag.next;
            }

            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }

            cur = cur.next;
        }

        tag.next = null;
        return node.next;
    }
}
