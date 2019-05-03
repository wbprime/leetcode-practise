package im.wangbo.java.leetcode.sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class Merge2SortedArraySolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] n, final int[] m, final int[] expected) {
        final Merge2SortedArraySolution s = new Merge2SortedArraySolution();

        s.merge(n, expected.length - m.length, m, m.length);

        final int[] result = Arrays.copyOf(n, expected.length);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, new int[]{2, 5, 6}, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0, 8}, new int[]{2, 5, 6}, new int[]{1, 2, 2, 3, 5, 6}),
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, new int[]{2, 5, 6}, new int[]{2, 5, 6}),
                Arguments.of(new int[]{1, 2, 3, 0, 0, 0, 8}, new int[]{}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{})
        );
    }
}