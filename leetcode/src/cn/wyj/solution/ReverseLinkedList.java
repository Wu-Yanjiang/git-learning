package cn.wyj.solution;

import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //递归解
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        else {
            /**()表示假设已经翻转好
             *  A->B->C->D
             * A->(B->C->D)
             * (B->C->D)->A
             *
             * B->C->D
             * B->(C->D)
             * (C->D)->B
             *
             * C->D
             * C->(D)
             * (D)->C
             *
             * D
             *
             * (head) -> (newHead)
             * head.next.next = head; => (head)->(newHead)->(head)
             * head.next = null;      => head->null (newHead)->(head)->null
             *
             * **/

            ListNode newHead = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }

    //-----****非递归解
    public ListNode reverseList3(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /***用栈实现空间复杂度太高*/
    public ListNode reverseList(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode p = head;
        while (p != null) {
            s.push(p.val);
            p = p.next;
        }
        p = head;
        while (p != null) {
            p.val = s.pop();
            p = p.next;
        }
        return head;
    }
}
