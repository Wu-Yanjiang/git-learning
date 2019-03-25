package cn.wyj.solution;

import java.util.List;

public class ReverseLinkedListII {
    /**定义节点*/
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1), pre = dummy, cur, t;
        dummy.next = head;
        for (int i=0; i<m-1; i++)
            pre = pre.next;
        cur = pre.next;
        for (int i=m; i<n; ++i){
            t = cur.next;
            cur.next = t.next;
            t.next = pre.next;
            pre.next = t;
        }
        return dummy.next;

    }

    public ListNode reverseBetween2(ListNode head, int m, int n){
        ListNode pre = new ListNode(-1), p, q, t;
        int i=1;
        p = head;
        pre.next = head;
        while (i<m){
            pre = p;
            p = p.next;
            ++i;
        }
        t = p;

        if (m<n){
            p = p.next;
            ++i;
        }
        while (i<=n){
            q=p;
            p = p.next;
            ++i;
            q.next = pre.next;
            pre.next=q;
        }
        t.next = p;
        return head;
    }


    public int getMin(int[] arr, int n) {
        int left = 0;
        int right = arr.length-1;
        int mid=0;
        while(left < right){
            mid = left + (right - left)/2;
            //这是判断已经被改动位置的循环数组
            if(arr[mid] > arr[left]){
                left = mid;//这是判断在右边最小有序
            }else if(arr[mid] < arr[left]){
                right = mid;//这是判断在左边最小有序
            }else{
                //这是left=mid的情况时
                mid++;
                break;
            }
        }
        int min = arr[mid];
        //还要判断一下没有改动循环数组的情况
        return min>arr[0]? arr[0]:min;
    }
}
