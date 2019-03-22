package cn.wyj.solution;

import java.util.List;

public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head, slow = head;
        do {
            slow = slow.next;
            if (slow == null)
                return null;

            fast = fast.next;
            if (fast == null)
                return null;

            fast = fast.next;
            if (fast == null)
                return null;
        } while (fast != slow);


        //循环检测法2：
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }


        //出了循环必有环存在，且slow和fast必在环中
        ListNode p = head;
        while (p != slow) {
            if (test(slow, fast, p))
                break;
            p = p.next;
        }
        return p;
    }

    //检测p是否进入环
    public boolean test(ListNode slow, ListNode fast, ListNode p) {
        do {
            fast = fast.next;
            //环中碰到p了
            if (fast == p)
                return true;
        } while (slow != fast);
        //环中没有碰到p，就返回
        return false;
    }
}
