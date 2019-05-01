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
class ArrayPlusOneSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int[] expected) {
        final ArrayPlusOneSolution s = new ArrayPlusOneSolution();

        final int[] result = s.plusOne(arr);

        Assertions.assertThat(result).containsExactlyInAnyOrder(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{1, 2, 2, 2}),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                Arguments.of(new int[]{2, 9}, new int[]{3, 0}),
                Arguments.of(new int[]{9}, new int[]{1, 0}),
                Arguments.of(new int[]{4, 9, 5}, new int[]{4, 9, 6})
        );
    }
}