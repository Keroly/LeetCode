/*
    合并两个排序的列表

题目描述：
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class B14 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode result = list1.val < list2.val ? list1 : list2;
        if (result == list1){
            list1 = list1.next;
        }else {
            list2 = list2.next;
        }
        result.next = Merge(list1, list2);
        return result;
    }

}
