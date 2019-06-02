package im.wangbo.java.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class MergeIntervalsSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[][] input, final int[][] expected) {
        final MergeIntervalsSolution s = new MergeIntervalsSolution();
        final int[][] result = s.merge(input);

        Assertions.assertThat(result).containsExactlyInAnyOrder(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(arg0(), arg1(), arg2(), arg3());
    }

    static private Arguments arg0() {
        final int[][] matrix = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18},
        };

        final int[][] expected = {
                {1, 6},
                {8, 10},
                {15, 18},
        };

        return Arguments.of(matrix, expected);
    }

    static private Arguments arg1() {
        final int[][] matrix = {
                {1, 4,},
                {4, 5,},
        };

        final int[][] expected = {
                {1, 5},
        };

        return Arguments.of(matrix, expected);
    }

    static private Arguments arg2() {
        final int[][] matrix = {
                {1, 3},
        };

        final int[][] expected = {
                {1, 3},
        };

        return Arguments.of(matrix, expected);
    }

    static private Arguments arg3() {
        final int[][] matrix = {
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10},
        };

        final int[][] expected = {
                {1, 10},
        };

        return Arguments.of(matrix, expected);
    }
}