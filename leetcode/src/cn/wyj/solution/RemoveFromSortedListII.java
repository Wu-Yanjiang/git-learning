package cn.wyj.solution;

public class RemoveFromSortedListII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null || head.next == null)
            return head;
        //至少2个节点
        ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
        fakeHead.next = head;
        ListNode pre, cur, next;
        pre = fakeHead;
        while (pre.next != null) {
            cur = pre.next;
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (cur != pre.next)
                pre.next = cur.next;
            else
                pre = pre.next;
        }

        return fakeHead.next;
    }
}
