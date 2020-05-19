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

    public void copy_node(Node head) {
        Node cur = head;
        while (cur != null){
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
    }
    public void copy_random(Node head) {
        Node cur = head;
        while (cur != null){
            Node next = cur.next.next;
            if (cur.random != null) {
                cur.next.random = cur. random.next;
            }
            cur = next;
        }
    }
    public Node split(Node head) {
        Node res = head.next;
        Node pre = head;
        Node cur = head.next;
        while (cur.next != null){
            Node temp = cur.next;
            pre.next = temp;
            cur.next = temp.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        copy_node(head);
        copy_random(head);
        return split(head);
    }

}
