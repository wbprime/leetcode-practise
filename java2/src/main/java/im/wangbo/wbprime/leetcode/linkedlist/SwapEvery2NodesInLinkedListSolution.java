package im.wangbo.wbprime.leetcode.linkedlist;

import im.wangbo.wbprime.leetcode.ListNode;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class SwapEvery2NodesInLinkedListSolution {
    public ListNode swap(final ListNode list) {
        if (list == null || list.next == null) return null;

        final ListNode result = list.next;

        ListNode cur = result.next;
        result.next = list;
        list.next = cur;
        cur = list;
        while (cur.next != null && cur.next.next != null) {
            final ListNode next = cur.next;
            final ListNode nnext = next.next;

            final ListNode tmp = nnext.next;

            cur.next = nnext;
            nnext.next = next;
            next.next = tmp;

            cur = next;
        }

        // Drop last odd node
        if (cur.next != null) cur.next = null;

        return result;
    }
}
