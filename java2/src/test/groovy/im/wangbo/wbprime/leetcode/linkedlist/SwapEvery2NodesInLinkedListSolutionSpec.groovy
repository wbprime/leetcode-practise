package im.wangbo.wbprime.leetcode.linkedlist


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
class SwapEvery2NodesInLinkedListSolutionSpec extends Specification {
    def "test swap adjacent nodes in LinkedList"() {
        given:
        int[] arr = ArrayDatas.random(ArrayDatas.randomValue(0, 100), -100, 100)
        ListNode head = ListNodes.create(arr)

        doOn(arr)

        def s = new SwapEvery2NodesInLinkedListSolution()
//        ListNodes.print(head)

        when:
        def result = s.swap(head)
//        ListNodes.print(result)

        then:
        ListNodes.assertEquals(result, arr, (arr.length % 2 == 0) ? arr.length : arr.length - 1)

        where:
        fori << (0..100)
    }

    static void doOn(int[] arr) {
        for (int i = 0; i + 1 < arr.length; i += 2) {
            int tmp = arr[i + 1]
            arr[i + 1] = arr[i]
            arr[i] = tmp
        }
    }
}
