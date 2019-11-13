/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class T0002 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    public static ListNode process(ListNode l1, ListNode l2, int nums){
        int next = 0;
        int num = 0;
        ListNode node = new ListNode(0);
        if (l1 != null && l2 != null){
            next = (l1.val + l2.val + nums) / 10;
            num = (l1.val + l2.val + nums) % 10;
            l1 = l1.next;
            l2 = l2.next;
        }else if (l2 != null ){
            next = (l2.val + nums) / 10;
            num = (l2.val + nums) % 10;
            l2 = l2.next;
        }else if (l1 != null){
            next = (l1.val + nums) / 10;
            num = (l1.val + nums) % 10;
            l1 = l1.next;
        }else {
            if(nums == 0){
                return null;
            }else {
                node.val = nums;
                node.next = null;
                return node;
            }

        }

        node.val = num;
        node.next = process(l1, l2, next);
        return node;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return process(l1, l2, 0);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(8);
        l1 = addTwoNumbers(l1,l2);
        while (l1 != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
