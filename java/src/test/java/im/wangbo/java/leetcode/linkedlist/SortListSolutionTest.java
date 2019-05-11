package im.wangbo.java.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class SortListSolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void test(final ListNode head, int[] expected) {
        final SortListSolution s = new SortListSolution();

        final ListNode result = s.sortList(head);

        assertListEquals(result, expected);
    }

    static void assertListEquals(final ListNode head, int[] expected) {
        int i = 0;
        ListNode cur = head;
        while (i < expected.length) {
            Assertions.assertThat(cur).as("Node %d not null", i).isNotNull();
            Assertions.assertThat(cur.val).as("Node %d not equals %d", i, expected[i]).isEqualTo(expected[i++]);
            cur = cur.next;
        }
        Assertions.assertThat(cur).isNull();
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(create(new int[]{3, 2, 0, -4}), new int[]{-4, 0, 2, 3}),
                Arguments.of(create(new int[]{3, 1}), new int[]{1, 3}),
                Arguments.of(create(new int[]{3}), new int[]{3}),
                Arguments.of(create(new int[]{3, 2, -4}), new int[]{-4, 2, 3})
        );
    }

    static ListNode create(final int[] arr) {
        final ListNode head = new ListNode(-1);

        ListNode cur = head;
        for (int v : arr) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }

        return head.next;
    }

}