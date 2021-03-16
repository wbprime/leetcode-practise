package im.wangbo.wbprime.leetcode.mergesort;

import im.wangbo.wbprime.leetcode.ListNode;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MergeSortLinkedListSolution {
    public ListNode sort(final ListNode list) {
        if (null == list || list.next == null) return list;

        final ListNode mid = findMid(list);
        final ListNode nmid = mid.next;
        mid.next = null;

        final ListNode a = sort(list);
        final ListNode b = sort(nmid);
        return merge(a, b);
    }

    public ListNode merge(final ListNode a, final ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else {
            ListNode head;

            ListNode la;
            ListNode lb;
            if (a.val > b.val) {
                head = a;
                la = a.next;
                lb = b;
            } else {
                head = b;
                la = a;
                lb = b.next;
            }

            ListNode cur = head;
            while (la != null && lb != null) {
                if (la.val > lb.val) {
                    cur.next = la;
                    la = la.next;
                } else {
                    cur.next = lb;
                    lb = lb.next;
                }
                cur = cur.next;
            }

            if (la != null) cur.next = la;
            if (lb != null) cur.next = lb;

            return head;
        }
    }

    private ListNode findMid(final ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;

            fast = fast.next.next;
        }

        return slow;
    }
}
