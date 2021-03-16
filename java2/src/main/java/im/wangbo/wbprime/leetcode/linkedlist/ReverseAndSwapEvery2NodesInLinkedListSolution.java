package im.wangbo.wbprime.leetcode.linkedlist;

import im.wangbo.wbprime.leetcode.ListNode;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class ReverseAndSwapEvery2NodesInLinkedListSolution {
    public ListNode solve(final ListNode list) {
        if (list == null || list.next == null) return null;

        ListNode cur = null;
        ListNode next = list;
        while (next != null && next.next != null) {
            ListNode nnext = next.next;

            ListNode tmp = nnext.next;

            nnext.next = cur;
            cur = next;
            next = tmp;
        }

        return cur;
    }
}
