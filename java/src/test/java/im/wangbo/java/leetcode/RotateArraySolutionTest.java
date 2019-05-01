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
class RotateArraySolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int k, final int[] expected) {
        final RotateArraySolution s = new RotateArraySolution();

        s.rotate(arr, k);

        Assertions.assertThat(arr).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 0, new int[]{1, 2, 3, 4, 5, 6, 7}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 1, new int[]{7, 1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 2, new int[]{6, 7, 1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 4, new int[]{4, 5, 6, 7, 1, 2, 3}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 5, new int[]{3, 4, 5, 6, 7, 1, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 6, new int[]{2, 3, 4, 5, 6, 7, 1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 7, new int[]{1, 2, 3, 4, 5, 6, 7}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 8, new int[]{7, 1, 2, 3, 4, 5, 6})
        );
    }
}