package im.wangbo.wbprime.leetcode.multimerge

import im.wangbo.wbprime.leetcode.ArrayDatas
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class MultiMergeSolutionSpec extends Specification {
    def "test multi merge"() {
        given:
        MultiMergeSolution s = new MultiMergeSolution()
        final int n = size as int;
        int[][] input = ArrayDatas.random(n, 10, 0, 1000)

        for (int i = 0; i < n; i++) {
            Arrays.sort(input[i])
        }
        println input

        when:
        def arr = s.sort(input)
        println(arr)

        then:
        ArrayDatas.assertSorted(arr)

        where:
        size << ArrayDatas.random(100, 0, 5)
    }
}
