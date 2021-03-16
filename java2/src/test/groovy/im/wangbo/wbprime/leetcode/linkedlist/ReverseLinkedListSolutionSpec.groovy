package im.wangbo.wbprime.leetcode.linkedlist

import com.google.common.primitives.Ints
import im.wangbo.wbprime.leetcode.ArrayDatas
import im.wangbo.wbprime.leetcode.ListNode
import im.wangbo.wbprime.leetcode.ListNodes
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class ReverseLinkedListSolutionSpec extends Specification {
    def "test reverse LinkedList"() {
        given:
        int[] arr = ArrayDatas.random(ArrayDatas.randomValue(0, 100), -100, 100)
        ListNode head = ListNodes.create(arr)

        Ints.reverse(arr)

        def s = new ReverseLinkedListSolution()
//        ListNodes.print(head)

        when:
        def result = s.reverse(head)
//        ListNodes.print(result)

        then:
        ListNodes.assertEquals(result, arr)

        where:
        fori << (0..100)
    }
}
