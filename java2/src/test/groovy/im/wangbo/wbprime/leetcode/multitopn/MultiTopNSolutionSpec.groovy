package im.wangbo.wbprime.leetcode.multitopn

import com.google.common.primitives.Ints
import im.wangbo.wbprime.leetcode.ArrayDatas
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class MultiTopNSolutionSpec extends Specification {
    def "test multi top N in cumulative length array"() {
        given:
        MultiTopNInCumulativeArraySolution s = new MultiTopNInCumulativeArraySolution()
        int[] existed = [3, -2, 5] as int[]
        int[] daily = [1, 8] as int[]
        int n = 3

        int[][] expected = new int[daily.length][]
        expected[0] = new int[Math.min(n, existed.length + daily.length)]
        expected[0][0] = 5
        expected[0][1] = 3
        expected[0][2] = 1
        expected[1] = new int[Math.min(n, existed.length + daily.length)]
        expected[1][0] = 8
        expected[1][1] = 5
        expected[1][2] = 3
//        println(existed)
//        println(daily)
//        println(n)
//        println(expected)

        when:
        def result = s.solve(existed, daily, n)
//        println(result)

        then:
        result == expected
    }

    def "test multi top N in cumulative length (m) array randomly"() {
        given:
        MultiTopNInCumulativeArraySolution s = new MultiTopNInCumulativeArraySolution()
        int[] existed = ArrayDatas.random(ArrayDatas.randomValue(0, 100), -100, 100)
        int[] daily = ArrayDatas.random(ArrayDatas.randomValue(0, 100), -100, 100)
        int n = ArrayDatas.randomValue(0, 20)

        int[][] expected = new int[daily.length][]
        for (int i = 0; i < daily.length; i++) {
            final int[] tmp = new int[existed.length + i + 1];
            System.arraycopy(existed, 0, tmp, 0, existed.length)
            System.arraycopy(daily, 0, tmp, existed.length, i + 1)

            Ints.sortDescending(tmp)

            final int len2 = Math.min(n, tmp.length);
            final int[] tmp2 = new int[len2];
            System.arraycopy(tmp, 0, tmp2, 0, len2)

            expected[i] = tmp2
        }
//        println(existed)
//        println(daily)
//        println(n)
//        println(expected)

        when:
        def result = s.solve(existed, daily, n)
//        println(result)

        then:
        result == expected

        where:
        fori << (0..100)
    }

    def "test multi top N in fix length array"() {
        given:
        def s = new MultiTopNInFixArraySolution()
        int[] existed = [3, -2, 5] as int[]
        int[] daily = [1, 8, 4] as int[]
        int n = 3
        int m = n + 1

        int[][] expected = new int[daily.length][]
        expected[0] = new int[Math.min(n, existed.length + daily.length)]
        expected[0][0] = 5
        expected[0][1] = 3
        expected[0][2] = 1
        expected[1] = new int[Math.min(n, existed.length + daily.length)]
        expected[1][0] = 8
        expected[1][1] = 5
        expected[1][2] = 1
        expected[2] = new int[Math.min(n, existed.length + daily.length)]
        expected[2][0] = 8
        expected[2][1] = 5
        expected[2][2] = 4
//        println(existed)
//        println(daily)
//        println(n)
//        println(expected)

        when:
        def result = s.solve(existed, daily, m, n)
//        println(result)

        then:
        result == expected
    }

    def "test multi top N in fix length (m) array randomly"() {
        given:
        def s = new MultiTopNInFixArraySolution()
        int[] existed = ArrayDatas.random(ArrayDatas.randomValue(0, 100), -100, 100)
        int[] daily = ArrayDatas.random(ArrayDatas.randomValue(0, 30), -100, 100)
        int n = ArrayDatas.randomValue(0, 10)
        int m = n + ArrayDatas.randomValue(0, 50)

        final int[] all = new int[existed.length + daily.length];
        System.arraycopy(existed, 0, all, 0, existed.length)
        System.arraycopy(daily, 0, all, existed.length, daily.length)

        int[][] expected = new int[daily.length][]
        for (int i = 0; i < daily.length; i++) {
            final int len = Math.min(m, existed.length + i + 1)
            final int[] tmp = new int[len];

            for (int k = 0, j = existed.length + i; j >= 0 && j >= existed.length + i + 1 - tmp.length; j--, k++) {
                tmp[k] = all[j]
            }

            Ints.sortDescending(tmp)

            final int len2 = Math.min(n, tmp.length);
            final int[] tmp2 = new int[len2];
            System.arraycopy(tmp, 0, tmp2, 0, len2)

            expected[i] = tmp2
        }
//        println(existed)
//        println(daily)
//        println(m)
//        println(n)
//        println(expected)

        when:
        def result = s.solve(existed, daily, m, n)
//        println(result)

        then:
        result == expected

        where:
        fori << (0..100)
    }
}
