package im.wangbo.wbprime.leetcode.knapsack


import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class TakeOrNotKnapsackSolutionSpec extends Specification {
    def "test 0-1 knapsack solution items"() {
        given:
//        def n = ArrayDatas.randomValue(0, 10)
        int[] values = [3, 1, 7, 5, 9]
        int[] prices = [2, 8, 4, 6, 3]

        TakeOrNotKnapsackSolution s = new TakeOrNotKnapsackSolution()

        int holding = 22; //ArrayDatas.randomValue(10, 1000)

        when:
        def result = s.solveItems(prices, values, holding)
        println(result)

        then:
        result.size() == 5
    }

    def "test 0-1 knapsack solution value"() {
        given:
//        def n = ArrayDatas.randomValue(0, 10)
        int[] values = [3, 1, 7, 5, 9]
        int[] prices = [2, 8, 4, 6, 3]

        TakeOrNotKnapsackSolution s = new TakeOrNotKnapsackSolution()

        int holding = 22; //ArrayDatas.randomValue(10, 1000)
        int expected = s.solveLegacy(prices, values, holding)

        when:
        def result = s.solve(prices, values, holding)
        println(result)

        then:
        result == expected
    }
}
