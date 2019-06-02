package im.wangbo.java.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class SpiralMatrixSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[][] input, final List<Integer> expected) {
        final SpiralMatrixSolution s = new SpiralMatrixSolution();
        final List<Integer> result = s.spiralOrder(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(arg0(), arg1(), arg2());
    }

    static private Arguments arg0() {
        final int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        final List<Integer> list = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);

        return Arguments.of(matrix, list);
    }

    static private Arguments arg1() {
        final int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };

        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);

        return Arguments.of(matrix, list);
    }

    static private Arguments arg2() {
        final int[][] matrix = {
                {1, 2, 3},
        };

        final List<Integer> list = Arrays.asList(1, 2, 3);

        return Arguments.of(matrix, list);
    }

}