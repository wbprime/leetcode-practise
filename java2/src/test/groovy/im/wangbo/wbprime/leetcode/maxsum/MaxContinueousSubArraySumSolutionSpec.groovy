package im.wangbo.wbprime.leetcode.maxsum


import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class MaxContinueousSubArraySumSolutionSpec extends Specification {
    def "test max sum"() {
        given:
        def s = new MaxContinueousSubArraySumSolution()

//        ArrayDatas.printArray(input)

        when:
        def result = s.maxSum(input)
//        println result

        then:
        result == expected

        where:
        input                                    | expected
        [] as int[]                              | 0
        [1] as int[]                             | 1
        [-1] as int[]                            | -1
        [0, -1, 2] as int[]                      | 2
        [1, -1, 2] as int[]                      | 2
        [2, -1, 2] as int[]                      | 3
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] as int[] | 6
    }

    def "test max sum and beg and end"() {
        given:
        def s = new MaxContinueousSubArraySumSolution()

//        ArrayDatas.printArray(input)

        int[] expected = [sum, beg, end]

        when:
        def result = s.maxSumAndBeginEnd(input)
//        ArrayDatas.printArray(result)
//        println()

        then:
        result == expected

        where:
        input                                    | sum | beg | end
        [] as int[]                              | 0   | -1  | -1
        [1] as int[]                             | 1   | 0   | 0
        [-1] as int[]                            | -1  | 0   | 0
        [0, -1, 2] as int[]                      | 2   | 2   | 2
        [1, -1, 2] as int[]                      | 2   | 0   | 2
        [2, -1, 2] as int[]                      | 3   | 0   | 2
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] as int[] | 6   | 3   | 6
    }
}
