package im.wangbo.wbprime.leetcode.maxsum

import im.wangbo.wbprime.leetcode.ArrayDatas
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class MaxProfitSolutionSpec extends Specification {
    def "test max profit"() {
        given:
        def s = new MaxProfitSolution()

//        ArrayDatas.printArray(input)
//        println()

        when:
        def result = s.maxProfit(input)
//        println result

        then:
        result == expected

        where:
        input                                        | expected
        [] as int[]                                  | 0
        [1] as int[]                                 | 0
        [-1] as int[]                                | 0
        [1, 2] as int[]                              | 1
        [2, 1] as int[]                              | 0
        [3, 2, 1] as int[]                           | 0
        [2, 2, 1, 3] as int[]                        | 2
        [2, 3, 2, 4] as int[]                        | 2
        [2, 4, 3, 5] as int[]                        | 3
        [9, 8, 7, 7, 6, 5] as int[]                  | 0
        [5, 6, 7, 7, 6, 5] as int[]                  | 2
        [5, 5, 6, 7, 6, 5] as int[]                  | 2
        [10, 8, 9, 6, 10, 9, 11, 12, 7, 11] as int[] | 6
    }

    def "test max profit and begin and end"() {
        given:
        def s = new MaxProfitSolution()

//        ArrayDatas.printArray(input)
//        println()

        int[] expected = [sum, beg, end]

        when:
        def result = s.maxProfitAndBeginEnd(input)
//        println result

        then:
        result == expected

        where:
        input                                                  | sum | beg | end
        [12, 13, 14, 1, 3] as int[]                            | 2   | 3   | 4
        [1, 2, 3, 1, 3] as int[]                               | 2   | 0   | 4
        [11, 12, 14, 1, 2, 3, 3, 4, 4, 4, 4, 1, 4] as int[]    | 3   | 3   | 12
        [11, 12, 14, 1, 2, 3, 3, 4, 4, 1, 4, 4, 1, 4] as int[] | 3   | 3   | 13
        [] as int[]                                            | 0   | -1  | -1
        [1] as int[]                                           | 0   | -1  | -1
        [-1] as int[]                                          | 0   | -1  | -1
        [1, 2] as int[]                                        | 1   | 0   | 1
        [2, 1] as int[]                                        | 0   | -1  | -1
        [2, 2, 1, 3] as int[]                                  | 2   | 2   | 3
        [2, 3, 2, 4] as int[]                                  | 2   | 0   | 3
        [2, 4, 3, 5] as int[]                                  | 3   | 0   | 3
        [9, 8, 7, 7, 6, 5] as int[]                            | 0   | -1  | -1
        [5, 6, 7, 7, 6, 5] as int[]                            | 2   | 0   | 3
        [5, 5, 6, 7, 6, 5] as int[]                            | 2   | 0   | 3
        [11, 13, 5, 5, 6, 7, 6, 5] as int[]                    | 2   | 2   | 5
        [10, 8, 9, 6, 10, 9, 11, 12, 7, 11] as int[]           | 6   | 3   | 7
        [5, 10, 5, 6, 11, 6, 5] as int[]                       | 6   | 0   | 4
        [5, 10, 4, 6, 11, 6, 5] as int[]                       | 7   | 2   | 4
        [5, 10, 4, 6, 11, 4, 11, 5] as int[]                   | 7   | 2   | 6
        [4, 10, 4, 6, 11, 4, 11, 5] as int[]                   | 7   | 0   | 6
        [6, 4, 10, 4, 6, 11, 4, 11, 5] as int[]                | 7   | 1   | 7
        [11, 12, 14, 1, 2, 3, 3, 4, 4, 4, 4, 1, 3] as int[]    | 3   | 3   | 10
    }
}
