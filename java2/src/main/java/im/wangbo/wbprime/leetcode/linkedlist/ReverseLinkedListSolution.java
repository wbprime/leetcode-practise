package im.wangbo.wbprime.leetcode.linkedlist;

import im.wangbo.wbprime.leetcode.ListNode;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class ReverseLinkedListSolution {
    public ListNode reverse(final ListNode list) {
        if (list == null || list.next == null) return list;

        ListNode cur = null;
        ListNode next = list;
        while (next != null) {
            final ListNode tmp = next.next;

            next.next = cur;
            cur = next;
            next = tmp;
        }

        return cur;
    }
}
