/*
    合并两个排序的列表
题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class B14 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(3);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        node2.next.next.next = new ListNode(5);

        node1 = Merge(node1, node2);
        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}
