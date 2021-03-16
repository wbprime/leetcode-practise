package im.wangbo.wbprime.leetcode.knapsack

import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class TakeOrNotFitKnapsackSolutionSpec extends Specification {
    def "test 0-1 fit knapsack solution value"() {
        given:
//        def n = ArrayDatas.randomValue(0, 10)
        int[] values = [3, 1, 7, 5, 9]
        int[] prices = [2, 8, 4, 6, 3]

        def s = new TakeOrNotFitKnapsackSolution()

        int holding = 20; //ArrayDatas.randomValue(10, 1000)
        int expected = 16

        when:
        def result = s.solve(prices, values, holding)
        println(result)

        then:
        result == expected
    }
}
