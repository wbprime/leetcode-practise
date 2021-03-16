package im.wangbo.wbprime.leetcode.mergesort

import im.wangbo.wbprime.leetcode.ArrayDatas
import im.wangbo.wbprime.leetcode.mergesort.MergeSortLinkedListSolution.ListNode
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class MergeSortLinkedListSolutionSpec extends Specification {
    def "test in debug mode"() {
        given:
        def s = new MergeSortLinkedListSolution()
        def l = new ListNode(ArrayDatas.randomValue(-10, 100))
        def cur = l
        for (int i = 0; i < ArrayDatas.randomValue(30, 100); i++) {
            cur.next = new ListNode(ArrayDatas.randomValue(-10, 100))
            cur = cur.next
        }
        printList l

        when:
        def newl = s.sort(l)
        printList newl

        then:
        assertListIsAscendingSorted(l, newl)

        where:
        fori << (0..1000)
    }

    static void assertListIsAscendingSorted(ListNode oldL, ListNode l) {
        if (null == oldL) {
            assert l == null
        } else {
            while (l != null && l.next != null) {
                assert l.val >= l.next.val
                l = l.next
            }
        }
    }

    static void printList(ListNode l) {
        if (l == null) {
            println("{}")
            return
        }

        print("{")
        print(l.val)
        while (l.next != null) {
            print(", ")
            print(l.next.val)

            l = l.next
        }
        println("}")
    }
}
