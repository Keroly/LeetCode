

/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */

/*
我们可以如下递归地定义在两个链表里的 merge 操作（忽略边界情况，比如空链表等）：


list1[0]+merge(list1[1:],list2)    list1[0]<list2[0]
list2[0]+merge(list1,list2[1:])    otherwise

也就是说，两个链表头部较小的一个与剩下元素的 merge 操作结果合并。
O(N+M) O(N+M)
 */
public class T0021 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        l1 = mergeTwoLists(l1,l2);
        while (l1 != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
