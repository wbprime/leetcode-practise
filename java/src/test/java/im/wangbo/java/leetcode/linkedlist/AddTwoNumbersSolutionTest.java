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
class AddTwoNumbersSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final ListNode head1, final ListNode head2, final int[] expected) {
        final AddTwoNumbersSolution s = new AddTwoNumbersSolution();

        final ListNode result = s.addTwoNumbers(head1, head2);

        assertListEquals(result, expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(create(new int[]{2, 4, 3}), create(new int[]{5, 6, 4}), new int[]{7, 0, 8}),
                Arguments.of(create(new int[]{2}), create(new int[]{8}), new int[]{0, 1})
        );
    }

    static private ListNode create(final int[] data) {
        final ListNode head = new ListNode(0);

        ListNode cur = head;
        for (int datum : data) {
            cur.next = new ListNode(datum);
            cur = cur.next;
        }

        return head.next;
    }

    private void assertListEquals(final ListNode head, final int[] data) {
        ListNode cur = head;

        for (int i = 0; i < data.length; i++) {
            Assertions.assertThat(cur).as("node at index %d", i).isNotNull();
            Assertions.assertThat(cur.val).as("value at index %d", i).isEqualTo(data[i]);
            cur = cur.next;
        }
        Assertions.assertThat(cur).isNull();
    }
}