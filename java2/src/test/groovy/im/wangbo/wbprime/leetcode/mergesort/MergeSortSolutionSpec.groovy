package im.wangbo.wbprime.leetcode.mergesort

import im.wangbo.wbprime.leetcode.ArrayDatas
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class MergeSortSolutionSpec extends Specification {
    def "test loop merge sort"() {
        given:
        def s = new MergeSortLooplySolution()

        when:
        s.sort(input)
        println input

        then:
        ArrayDatas.assertSorted(input)

        where:
        input                                | _
        [] as int[]                          | _
        [2] as int[]                         | _
        [2, 1] as int[]                      | _
        [2, 1, 3] as int[]                   | _
        [2, 1, 3, 2] as int[]                | _
        [2, 1, 4, 3, 2] as int[]             | _
        [2, 1, 4, 5, 3, 2] as int[]          | _
        [2, 1, 4, 5, 4, 3, 2] as int[]       | _
        [2, 1, 4, 2, 5, 4, 3, 2] as int[]    | _
        [2, 1, 4, 2, 5, 2, 4, 3, 2] as int[] | _
    }

    def "test recursive merge sort"() {
        given:
        def s = new MergeSortRecursivelySolution()

        when:
        s.sort(input)
        println input

        then:
        ArrayDatas.assertSorted(input)

        where:
        input                                | _
        [] as int[]                          | _
        [2] as int[]                         | _
        [2, 1] as int[]                      | _
        [2, 1, 3] as int[]                   | _
        [2, 1, 3, 2] as int[]                | _
        [2, 1, 4, 3, 2] as int[]             | _
        [2, 1, 4, 5, 3, 2] as int[]          | _
        [2, 1, 4, 5, 4, 3, 2] as int[]       | _
        [2, 1, 4, 2, 5, 4, 3, 2] as int[]    | _
        [2, 1, 4, 2, 5, 2, 4, 3, 2] as int[] | _
    }
}
