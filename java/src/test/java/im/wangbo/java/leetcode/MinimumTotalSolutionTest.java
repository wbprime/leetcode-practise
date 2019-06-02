package im.wangbo.java.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class MinimumTotalSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final List<List<Integer>> input, final int expected) {
        final MinimumTotalSolution s = new MinimumTotalSolution();
        final int result = s.minimumTotal(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(arg0(), arg1(), arg2(), arg3());
    }

    private static List<List<Integer>> createList(final int[][] arr) {
        final List<List<Integer>> result = new ArrayList<>(arr.length);

        for (int[] a : arr) {
            final List<Integer> l = new ArrayList<>(a.length);
            for (int ae : a) {
                l.add(ae);
            }
            result.add(l);
        }

        return result;
    }

    static private Arguments arg0() {
        final int[][] matrix = {
                {1,},
                {2, 6},
        };

        return Arguments.of(createList(matrix), 3);
    }

    static private Arguments arg1() {
        final int[][] matrix = {
                {1,},
        };

        return Arguments.of(createList(matrix), 1);
    }

    static private Arguments arg2() {
        final int[][] matrix = {
                {1,},
                {6, 2},
        };

        return Arguments.of(createList(matrix), 3);
    }

    static private Arguments arg3() {
        final int[][] matrix = {
                {2,},
                {3, 4,},
                {6, 5, 7,},
                {4, 1, 8, 3},
        };

        return Arguments.of(createList(matrix), 11);
    }
}