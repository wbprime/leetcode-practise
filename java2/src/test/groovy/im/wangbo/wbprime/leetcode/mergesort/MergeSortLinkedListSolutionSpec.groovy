package im.wangbo.wbprime.leetcode.mergesort

import im.wangbo.wbprime.leetcode.ArrayDatas
import im.wangbo.wbprime.leetcode.ListNodes
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
        int[] arr = ArrayDatas.random(ArrayDatas.randomValue(0, 100), -100, 100)
        def head = ListNodes.create(arr)

        Arrays.sort(arr)

        def s = new MergeSortLinkedListSolution()
//        ListNodes.print head

        when:
        def result = s.sort(head)
//        ListNodes.print result

        then:
        ListNodes.assertEquals(result, arr)

        where:
        fori << (0..100)
    }
}
