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
class LinkedListIsPalindromeSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final ListNode head, boolean expected) {
        final LinkedListIsPalindromeSolution s = new LinkedListIsPalindromeSolution();

        final boolean result = s.isPalindrome(head);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static ListNode create(final int[] arr) {
        final ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int i = 0; i < arr.length; i++) {
            final ListNode next = new ListNode(arr[i]);
            node.next = next;
            node = next;
        }
        node.next = null;
        return head.next;
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(create(new int[]{8}), true),
                Arguments.of(create(new int[]{}), true),
                Arguments.of(create(new int[]{1, 2, 2, 1}), true),
                Arguments.of(create(new int[]{1, 2}), false)
        );
    }
}