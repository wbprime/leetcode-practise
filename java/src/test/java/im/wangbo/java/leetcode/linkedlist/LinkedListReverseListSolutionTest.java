package im.wangbo.java.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import im.wangbo.java.leetcode.linkedlist.LinkedListReverseListSolution;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class LinkedListReverseListSolutionTest {
    @Test
    void test() {
        final int n = ThreadLocalRandom.current().nextInt(100) + 1;
        LinkedListReverseListSolution.ListNode node = new LinkedListReverseListSolution.ListNode(-1);
        LinkedListReverseListSolution.ListNode head = node;

        for (int i = 0; i < n; i++) {
            LinkedListReverseListSolution.ListNode next = new LinkedListReverseListSolution.ListNode(i);
            node.next = next;
            node = next;
        }
        node.next = null;

        final LinkedListReverseListSolution s = new LinkedListReverseListSolution();

        final LinkedListReverseListSolution.ListNode result = s.reverseList(head);

        {
            LinkedListReverseListSolution.ListNode tmp = result;
            for (int i = n - 1; i >= -1; i--) {
                Assertions.assertThat(tmp.val).isEqualTo(i);
                tmp = tmp.next;
            }
            Assertions.assertThat(tmp).isNull();
        }
    }
}