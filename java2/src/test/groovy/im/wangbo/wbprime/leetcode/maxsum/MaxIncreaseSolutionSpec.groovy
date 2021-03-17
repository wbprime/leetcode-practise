package im.wangbo.wbprime.leetcode.maxsum

import im.wangbo.wbprime.leetcode.ArrayDatas
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class MaxIncreaseSolutionSpec extends Specification {
    def "test max increase"() {
        given:
        def s = new MaxIncreaseSolution()

        ArrayDatas.printArray(input)
        println()

        when:
        def result = s.solve(input)
        println result

        then:
        result == expected

        where:
        input                                        | expected
        [] as int[]                                  | 0
        [1] as int[]                                 | 0
        [1, 2] as int[]                              | 1
        [2, 1] as int[]                              | 0
        [3, 2, 1] as int[]                           | 0
        [2, 2, 1, 3] as int[]                        | 2
        [2, 3, 2, 4] as int[]                        | 3
        [2, 4, 3, 5] as int[]                        | 4
        [9, 8, 7, 7, 6, 5] as int[]                  | 0
        [5, 6, 7, 7, 6, 5] as int[]                  | 2
        [5, 5, 6, 7, 6, 5] as int[]                  | 2
        [10, 8, 9, 6, 10, 9, 11, 12, 7, 11] as int[] | 12
        [7, 1, 5, 3, 6, 4] as int[]                  | 7
        [7, 6, 4, 3, 1] as int[]                     | 0
        [1, 2, 3, 4, 5] as int[]                     | 4
    }
}
