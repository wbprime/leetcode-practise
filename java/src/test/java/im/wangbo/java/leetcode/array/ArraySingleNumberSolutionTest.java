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
class ArraySingleNumberSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int expected) {
        final ArraySingleNumberSolution s = new ArraySingleNumberSolution();

        final int result = s.singleNumber(arr);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 1}, 1),
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4)
        );
    }
}