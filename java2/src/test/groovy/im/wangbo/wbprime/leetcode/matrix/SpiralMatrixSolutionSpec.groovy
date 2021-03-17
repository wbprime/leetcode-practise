package im.wangbo.wbprime.leetcode.matrix

import im.wangbo.wbprime.leetcode.ArrayDatas
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class SpiralMatrixSolutionSpec extends Specification {
    def "test generate spiral matrix"() {
        given:
        def s = new SpiralMatrixSolution()

//        println n

        when:
        def result = s.generate(n)
//        ArrayDatas.printMatrix(result)

        then:
        result == expected

        where:
        n | expected
        1 | [[1]] as int[][]
        2 | [[1, 2], [4, 3]] as int[][]
        3 | [[1, 2, 3], [8, 9, 4], [7, 6, 5]] as int[][]
        4 | [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]] as int[][]
        5 | [[1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9]] as int[][]
    }

    def "test walk spiral matrix"() {
        given:
        def s = new SpiralMatrixSolution()

        final int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            matrix[i] = ArrayDatas.random(n, -100, 100)
//        ArrayDatas.printMatrix(matrix)

        when:
        def result = s.walk(matrix)
//        ArrayDatas.printArray(result)

        then:
        result.size() == m * n

        where:
        m | n
        3 | 4
        3 | 6
        4 | 3
        6 | 3
        6 | 8
        8 | 6
        7 | 9
        9 | 7
    }
}
