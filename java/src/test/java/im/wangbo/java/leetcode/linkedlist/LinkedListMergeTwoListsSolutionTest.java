package im.wangbo.java.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class LinkedListMergeTwoListsSolutionTest {
    @Test
    void test() {
        final ListNode head1;
        final int n1;
        final ListNode head2;
        final int n2;
        {
            n1 = ThreadLocalRandom.current().nextInt(100) + 1;
            ListNode node = new ListNode(-1);
            head1 = node;

            for (int i = 0; i < n1; i++) {
                ListNode next = new ListNode(i * 2 + 1);
                node.next = next;
                node = next;
            }
            node.next = null;
        }
        {
            n2 = ThreadLocalRandom.current().nextInt(100) + 1;
            ListNode node = new ListNode(-2);
            head2 = node;

            for (int i = 0; i < n2; i++) {
                ListNode next = new ListNode(i * 2);
                node.next = next;
                node = next;
            }
            node.next = null;
        }

        final LinkedListMergeTwoListsSolution s = new LinkedListMergeTwoListsSolution();

        final ListNode result = s.mergeTwoLists(head1, head2);

        {
            ListNode tmp = result;
            int min = Integer.MIN_VALUE;
            int count = 0;
            while (null != tmp) {
                Assertions.assertThat(tmp.val).isGreaterThan(min);
                min = tmp.val;

                tmp = tmp.next;

                count++;
            }
            Assertions.assertThat(count).isEqualTo(n1 + n2 + 2); // plus 2 dummy head
        }
    }
}