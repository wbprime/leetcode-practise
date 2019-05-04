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
class GetIntersectionNodeSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final ListNode head1, final ListNode head2, final ListNode expected) {
        final GetIntersectionNodeSolution s = new GetIntersectionNodeSolution();

        final ListNode result = s.getIntersectionNode(head1, head2);

        Assertions.assertThat(result).isSameAs(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                create3(),
                create2(),
                create1()
        );
    }

    static private Arguments create3() {
        final ListNode share = null;

        final ListNode head1 = createList(new int[]{4, 6, 2}, share);
        final ListNode head2 = createList(new int[]{1}, share);

        return Arguments.of(head1, head2, share);
    }

    static private Arguments create2() {
        final ListNode share = createList(new int[]{4, 2}, null);

        final ListNode head1 = createList(new int[]{1, 9, 0}, share);
        final ListNode head2 = createList(new int[]{3}, share);

        return Arguments.of(head1, head2, share);
    }

    static private Arguments create1() {
        final ListNode share = createList(new int[]{5, 4, 8}, null);

        final ListNode head1 = createList(new int[]{1, 4}, share);
        final ListNode head2 = createList(new int[]{1, 0, 5}, share);

        return Arguments.of(head1, head2, share);
    }

    static private ListNode createList(final int[] arr, final ListNode end) {
        ListNode tmp = end;
        for (int v : arr) {
            final ListNode n = new ListNode(v);
            n.next = tmp;
            tmp = n;
        }
        return tmp;
    }
}