/*
    复杂链表的复制

题目描述：
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

 */

public class J35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public void copy(Node head){
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
    }

    public void copyRandom(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow != null) {
            if (slow.random != null) {
                fast.random = slow.random.next;
            }
            if (fast.next == null) {
                return;
            }
            fast = fast.next.next;
            slow = slow.next.next;
        }
    }

    public Node split (Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        Node res = fast;
        while (fast.next != null) {
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = null;
        return res;
    }

    public Node copyRandomList(Node head) {
        copy(head);
        copyRandom(head);
        return split(head);
    }
}
