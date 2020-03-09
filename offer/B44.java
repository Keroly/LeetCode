/*
    两个链表的第一个公共节点
题目描述
输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */

public class B44 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;

        while (node1 != null){
            len1++;
            node1 = node1.next;
        }
        while (node2 != null){
            len2++;
            node2 = node2.next;
        }

        node1 = pHead1;
        node2 = pHead2;

        for (int i = Math.abs(len1 - len2); i > 0; i--){
            if (len1 > len2){
                node1 = node1.next;
            }else {
                node2 = node2.next;
            }
        }

        while (node1 != null && node2 != null){
            if (node1 == node2){
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }
}
