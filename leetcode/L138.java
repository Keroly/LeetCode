/*
    复制带随机指针的链表

题目描述：
现在有一个这样的链表：链表的每一个节点都附加了一个随机指针，随机指针可能指向链表中的任意一个节点或者指向空。
 */

public class L138 {
    class RandomListNode {
       int label;
       RandomListNode next, random;
       RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode root = new RandomListNode(-1);
        RandomListNode cur = head;
        while (cur != null){
            RandomListNode node = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = node;
            cur = node;
        }

        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        root.next = head.next;
        RandomListNode old_cur = head;
        RandomListNode new_cur = head.next;
        while (new_cur.next != null){
            old_cur.next = new_cur.next;
            new_cur.next = old_cur.next.next;
            old_cur = old_cur.next;
            new_cur = new_cur.next;
        }
        old_cur.next = null;

        return root.next;
    }
}
