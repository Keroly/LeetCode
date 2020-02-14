/*
    从尾到头打印单链表
题目描述
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

import java.util.ArrayList;

public class B03 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) { // 递归
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(81);
        node.next.next = new ListNode(61);
        node.next.next.next = new ListNode(95);
        ArrayList list = printListFromTailToHead(node);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
