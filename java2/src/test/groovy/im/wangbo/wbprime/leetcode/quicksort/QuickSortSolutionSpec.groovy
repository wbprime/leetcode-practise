package im.wangbo.wbprime.leetcode.quicksort

import im.wangbo.wbprime.leetcode.ArrayDatas
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class QuickSortSolutionSpec extends Specification {
    def "test quick sort"() {
        given:
        def s = new QuickSortSolution()

        when:
        s.sort(input)

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
