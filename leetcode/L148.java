/*
    排序链表
题目描述：

 */
public class L148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode result = new ListNode(-1);
        ListNode cur = result;

        while (left != null && right != null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
            cur.next = null;
        }

        if (left != null){
            cur.next = left;
        }

        if (right != null){
            cur.next = right;
        }

        return result.next;
    }

    public ListNode cut(ListNode start, int size){
        if (start == null) return null;
        ListNode cur = start;
        while ((--size != 0) && (cur != null)){
            cur = cur.next;
        }
        if (cur == null){
            return null;
        }
        ListNode result = cur.next;
        cur.next = null;
        return result;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(-1);
        result.next = head;

        ListNode cur = head;
        int lens = 0;
        while (cur != null){
            lens++;
            cur = cur.next;
        }

        for (int size = 1; size < lens; size <<= 1){
            ListNode start = result.next;
            ListNode end = result;
            while (start != null){
                ListNode left = start;
                ListNode right = cut(left, size);
                start = cut(right, size);
                end.next = merge(left, right);
                while (end.next != null){
                    end = end.next;
                }
            }
        }

        return result.next;
    }
}
