package im.wangbo.wbprime.leetcode.knapsack

import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class BuyThenSellStocksSolutionSpec extends Specification {
    def "test buy then sell stocks knapsack solution value"(int[] buyPrices, int[] sellPrices, int totalAmount, int expected) {
        given:
        def s = new BuyThenSellStocksSolution()

        when:
        def result = s.solve(buyPrices, sellPrices, totalAmount)

        then:
        result == expected

        where:
        buyPrices                                   | sellPrices                                    | totalAmount | expected
        []                                          | []                                            | 100         | 0
        [100]                                       | [101]                                         | 100         | 1
        [10]                                        | [5]                                           | 20          | 0

        [2, 8, 4, 6, 3]                             | [4, 6, 4, 16, 2]                              | 58          | 94
        [2, 8, 4, 6, 3]                             | [5, 9, 11, 11, 12]                            | 22          | 63

        [153, 178, 37, 26, 260]                     | [180, 192, 294, 117, 81]                      | 85          | 514
        [188, 267, 233]                             | [262, 35, 252]                                | 55          | 0
        [228]                                       | [142]                                         | 377         | 0
        [13, 122, 124, 172, 105]                    | [152, 200, 69, 117, 229]                      | 303         | 3197
        [139, 145, 56, 5]                           | [34, 213, 29, 242]                            | 474         | 22278
        [286, 106, 13, 252, 78, 190, 110]           | [27, 3, 77, 120, 76, 20, 247]                 | 108         | 512
        [231, 160, 82, 298, 100]                    | [118, 143, 252, 54, 271]                      | 337         | 680
        [295, 244, 146, 257]                        | [70, 16, 157, 105]                            | 206         | 11
        [18, 6, 141, 67]                            | [67, 214, 100, 285]                           | 121         | 4160
        [106, 247, 178, 272, 165, 176, 165, 37]     | [246, 171, 262, 176, 116, 158, 191, 16]       | 366         | 420
        [295, 229]                                  | [22, 92]                                      | 234         | 0
        [107]                                       | [175]                                         | 451         | 272
    }

    static def generate() {
        Random r = new Random()

        (0..10).each {
            int d = r.nextInt(10)

            int[] buyPrices = new int[d]
            int[] sellPrices = new int[d]

            (0..<d).each {
                buyPrices[it] = r.nextInt(300) + 2
                sellPrices[it] = r.nextInt(300) + 2
            }

            int total = r.nextInt(500)

            println("$buyPrices | $sellPrices | $total | 0")
        }
    }
}
