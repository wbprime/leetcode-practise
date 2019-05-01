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
class ArrayMoveZerosSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int[] expected) {
        final ArrayMoveZerosSolution s = new ArrayMoveZerosSolution();

        s.moveZeros(arr);

        Assertions.assertThat(arr).containsExactly(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{1, 2, 2, 1}),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 1}),
                Arguments.of(new int[]{2, 0, 9}, new int[]{2, 9, 0}),
                Arguments.of(new int[]{0, 0, 9}, new int[]{9, 0, 0}),
                Arguments.of(new int[]{0, 9, 0, 8, 0}, new int[]{9, 8, 0, 0, 0})
        );
    }
}