package im.wangbo.java.leetcode.sorting;

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
class QuickSortTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, int[] expected) {
        final QuickSort s = new QuickSort();

        final int[] result = s.sort(arr);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{9, 4, 8, 3, 1, 2, 5}, new int[]{1, 2, 3, 4, 5, 8, 9}),
                Arguments.of(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{3}, new int[]{3})
        );
    }
}