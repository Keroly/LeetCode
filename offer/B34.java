/*
    复杂链表的复制
题目描述：
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class B34 {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static RandomListNode copy(RandomListNode head){ // 第一步：复制
        if (head == null) return head;
        RandomListNode cur = head;
        while (cur != null){
            RandomListNode tempNode = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = tempNode;
            cur = tempNode;
        }
        return head;
    }

    public static RandomListNode process(RandomListNode head){  // 第二步：挪指针
        if (head == null) return head;
        RandomListNode cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        return head;
    }

    public static RandomListNode split(RandomListNode head){    // 第三步： 拆链
        if (head == null) return head;
        RandomListNode old_head = head;
        RandomListNode new_head = head.next;
        RandomListNode old_cur = old_head;
        RandomListNode new_cur = new_head;
        while (new_cur.next != null){
            old_cur.next = new_cur.next;
            new_cur.next = new_cur.next.next;
            old_cur = old_cur.next;
            new_cur = new_cur.next;
        }
        old_cur.next = null;
        return new_head;
    }

    public static RandomListNode Clone(RandomListNode pHead){
        RandomListNode node = pHead;
        node = copy(node);
        node = process(node);
        node = split(node);
        return node;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node5;
        node4.random = node2;

        node1 = Clone(node1);
        while (node1 != null){
            System.out.printf(" " + node1.label);
            if (node1.random != null)   System.out.print(" " + node1.random.label);
            System.out.println();
            node1 = node1.next;
        }
    }
}
