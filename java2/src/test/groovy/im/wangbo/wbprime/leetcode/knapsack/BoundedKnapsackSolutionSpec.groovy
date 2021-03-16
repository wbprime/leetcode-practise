package im.wangbo.wbprime.leetcode.knapsack

import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class BoundedKnapsackSolutionSpec extends Specification {
    def "test bounded knapsack solution value"() {
        given:
//        def n = ArrayDatas.randomValue(0, 10)
        int[] values = [3, 1, 7, 5, 9]
        int[] prices = [2, 8, 4, 6, 3]
//        int[] counts = [1, 1, 1, 1, 1]
        int[] counts = [7, 20, 3, 4, 2]

        def s = new BoundedKnapsackSolution()

        int holding = 22; //ArrayDatas.randomValue(10, 1000)
//        int expected = 24
        int expected = 63

        when:
        def result = s.solve(prices, values, counts, holding)
        println(result)

        then:
        result == expected
    }
}
