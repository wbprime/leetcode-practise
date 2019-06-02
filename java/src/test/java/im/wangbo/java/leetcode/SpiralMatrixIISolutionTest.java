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
class SpiralMatrixIISolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int input, final int[][] expected) {
        final SpiralMatrixIISolution s = new SpiralMatrixIISolution();
        final int[][] result = s.generateMatrix(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(arg0(), arg1(), arg2());
    }

    static private Arguments arg0() {
        final int[][] matrix = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5},
        };

        return Arguments.of(3, matrix);
    }

    static private Arguments arg1() {
        final int[][] matrix = {
                {1, 2,},
                {4, 3,},
        };

        return Arguments.of(2, matrix);
    }

    static private Arguments arg2() {
        final int[][] matrix = {
                {1,},
        };

        return Arguments.of(1, matrix);
    }

}