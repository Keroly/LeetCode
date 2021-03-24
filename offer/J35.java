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
        Node node = head;
        while (node != null) {
            Node copyNode = new Node(node.val);
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }
    }

    public void copyRandom(Node head) {
        Node node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }

    public Node split (Node head) {
        Node res = head.next;
        Node node = res;
        while (node.next != null) {
            head.next = node.next;
            node.next = node.next.next;
            node = node.next;
            head = head.next;
        }
        head.next = null;
        return res;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        copy(head);
        copyRandom(head);
        return split(head);
    }
}
