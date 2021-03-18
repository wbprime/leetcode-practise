package im.wangbo.wbprime.leetcode.permutate

import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class NextPermuteSolutionTest extends Specification {
    def "test next permutation"() {
        given:
        def s = new NextPermuteSolution()

        int[] arr = input
        int[] expected = output

        when:
        def result = s.solve(arr)

        then:
        result == expected

        where:
        input           | output
        []              | []
        [1]             | [1]
        [1, 2]          | [2, 1]
        [2, 1]          | [2, 1]
        [2, 2, 1]       | [2, 2, 1]
        [1, 2, 2]       | [2, 1, 2]
        [1, 2, 3, 4, 5] | [1, 2, 3, 5, 4]
        [1, 2, 3]       | [1, 3, 2]
        [1, 3, 2]       | [2, 1, 3]
        [2, 1, 3]       | [2, 3, 1]
        [2, 3, 1]       | [3, 1, 2]
        [3, 1, 2]       | [3, 2, 1]
        [3, 2, 1]       | [3, 2, 1]
    }
}
