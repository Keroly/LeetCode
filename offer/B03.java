/*
    从尾到头打印单链表

题目描述：
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

import java.util.ArrayList;

public class B03 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) return result;

        ListNode pre = null;
        ListNode cur = listNode;

        while (cur != null){
            ListNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        while (pre != null){
            result.add(pre.val);
            pre = pre.next;
        }
        return result;
    }
}

//  修改源数据   时间：O(n) 空间：O(n) || 若不修改原数组，可以递归,可以用栈    时间：O(n) 空间：O(n)