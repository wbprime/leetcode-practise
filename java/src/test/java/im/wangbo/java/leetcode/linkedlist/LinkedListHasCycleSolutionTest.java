package im.wangbo.java.leetcode.linkedlist;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import im.wangbo.java.leetcode.linkedlist.LinkedListHasCycleSolution;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class LinkedListHasCycleSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final LinkedListHasCycleSolution.ListNode head, boolean expected) {
        final LinkedListHasCycleSolution s = new LinkedListHasCycleSolution();

        final boolean result = s.hasCycle(head);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static LinkedListHasCycleSolution.ListNode create1() {
        /*
         *      [3] -> [2] -> [0] -> [-4] -|
         *              ^- <- <- <- <- <- -|
         */

        final LinkedListHasCycleSolution.ListNode head = new LinkedListHasCycleSolution.ListNode(-1);

        final LinkedListHasCycleSolution.ListNode node1;
        final LinkedListHasCycleSolution.ListNode node2;
        final LinkedListHasCycleSolution.ListNode node3;
        final LinkedListHasCycleSolution.ListNode node4;

        {
            node1 = new LinkedListHasCycleSolution.ListNode(3);
            head.next = node1;
        }
        {
            node2 = new LinkedListHasCycleSolution.ListNode(2);
            node1.next = node2;
        }
        {
            node3 = new LinkedListHasCycleSolution.ListNode(0);
            node2.next = node3;
        }
        {
            node4 = new LinkedListHasCycleSolution.ListNode(-4);
            node3.next = node4;

            node4.next = node2; // Ring here
        }

        return head.next;
    }

    static LinkedListHasCycleSolution.ListNode create2() {
        /*
         *      [1] -> [2] -|
         *       ^- <- <- <-|
         */

        final LinkedListHasCycleSolution.ListNode head = new LinkedListHasCycleSolution.ListNode(-1);

        final LinkedListHasCycleSolution.ListNode node1;
        final LinkedListHasCycleSolution.ListNode node2;

        {
            node1 = new LinkedListHasCycleSolution.ListNode(1);
            head.next = node1;
        }
        {
            node2 = new LinkedListHasCycleSolution.ListNode(2);
            node1.next = node2;
            node2.next = node1; // Ring here
        }

        return head.next;
    }

    static LinkedListHasCycleSolution.ListNode create4() {
        /*
         *      [1] -> [2] -> null
         */

        final LinkedListHasCycleSolution.ListNode head = new LinkedListHasCycleSolution.ListNode(-1);

        final LinkedListHasCycleSolution.ListNode node1;
        final LinkedListHasCycleSolution.ListNode node2;

        {
            node1 = new LinkedListHasCycleSolution.ListNode(1);
            head.next = node1;
        }
        {
            node2 = new LinkedListHasCycleSolution.ListNode(2);
            node1.next = node2;
            node2.next = null;
        }

        return head.next;
    }

    static LinkedListHasCycleSolution.ListNode create3() {
        /*
         *      [1] -> null
         */

        final LinkedListHasCycleSolution.ListNode head = new LinkedListHasCycleSolution.ListNode(-1);

        final LinkedListHasCycleSolution.ListNode node1;

        {
            node1 = new LinkedListHasCycleSolution.ListNode(3);
            head.next = node1;
            node1.next = null;
        }

        return head.next;
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(create1(), true),
                Arguments.of(create2(), true),
                Arguments.of(create3(), false),
                Arguments.of(create4(), false)
        );
    }
}