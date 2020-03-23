/*
    合并K个排序链表
题目描述:
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L023 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;

        ListNode result = new ListNode(-1);
        ListNode cur = result;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null){
                queue.add(lists.get(i));
            }
        }

        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null){
                queue.add(node.next);
            }
        }

        return result.next;
    }
}
