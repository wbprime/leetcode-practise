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
class LinkedListDetectCycleSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final ListNode head, int expected) {
        final LinkedListDetectCycleSolution s = new LinkedListDetectCycleSolution();

        final ListNode result = s.detectCycle(head);

        if (-1 != expected) {
            Assertions.assertThat(result.val).isEqualTo(expected);
        } else {
            Assertions.assertThat(result).isNull();
        }
    }

    static ListNode create1() {
        /*
         *      [3] -> [2] -> [0] -> [-4] -|
         *              ^- <- <- <- <- <- -|
         */

        final ListNode head = new ListNode(-1);

        final ListNode node1;
        final ListNode node2;
        final ListNode node3;
        final ListNode node4;

        {
            node1 = new ListNode(3);
            head.next = node1;
        }
        {
            node2 = new ListNode(2);
            node1.next = node2;
        }
        {
            node3 = new ListNode(0);
            node2.next = node3;
        }
        {
            node4 = new ListNode(-4);
            node3.next = node4;

            node4.next = node2; // Ring here
        }

        return head.next;
    }

    static ListNode create2() {
        /*
         *      [1] -> [2] -|
         *       ^- <- <- <-|
         */

        final ListNode head = new ListNode(-1);

        final ListNode node1;
        final ListNode node2;

        {
            node1 = new ListNode(1);
            head.next = node1;
        }
        {
            node2 = new ListNode(2);
            node1.next = node2;
            node2.next = node1; // Ring here
        }

        return head.next;
    }

    static ListNode create4() {
        /*
         *      [1] -> [2] -> null
         */

        final ListNode head = new ListNode(-1);

        final ListNode node1;
        final ListNode node2;

        {
            node1 = new ListNode(1);
            head.next = node1;
        }
        {
            node2 = new ListNode(2);
            node1.next = node2;
            node2.next = null;
        }

        return head.next;
    }

    static ListNode create3() {
        /*
         *      [1] -> null
         */

        final ListNode head = new ListNode(-1);

        final ListNode node1;

        {
            node1 = new ListNode(3);
            head.next = node1;
            node1.next = null;
        }

        return head.next;
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(create1(), 2),
                Arguments.of(create2(), 1),
                Arguments.of(create3(), -1),
                Arguments.of(create4(), -1)
        );
    }
}