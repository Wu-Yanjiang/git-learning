package cn.wyj.solution;

import java.util.Random;

public class LinkedListRandomNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private int size = 0;
    private Random rd;
    private ListNode h;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public void Solution(ListNode head) {
        h = head;
        rd = new Random();
        while (head != null) {
            size++;
            head = head.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode p = h;
        for (int i = 0; i < rd.nextInt(size); i++) {
            p = p.next;
        }
        return p.val;
    }
}
