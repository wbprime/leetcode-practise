package im.wangbo.java.leetcode.array;

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
class Rotate2DArraySolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[][] arr, final int[][] expected) {
        final Rotate2DArraySolution s = new Rotate2DArraySolution();

        s.rotate(arr);

        Assertions.assertThat(arr).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        int[][] data1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] data2 = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        int[][] data3 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] data4 = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        return Stream.of(
                Arguments.of(data1, data2),
                Arguments.of(data3, data4)
        );
    }
}