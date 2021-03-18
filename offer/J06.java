/*
    从尾到头打印链表(n)

题目描述：
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 */

import java.util.Stack;

public class J06 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int flag = 0;
        while (!stack.isEmpty()) {
            ans[flag++] = stack.pop();
        }
        return ans;
    }
}
