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
class SearchInRotateSortedArraySolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int target, final int expected) {
        final SearchInRotateSortedArraySolution s = new SearchInRotateSortedArraySolution();
        final int result = s.search(arr, target);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, 1, 0),
                Arguments.of(new int[]{1, 3}, 3, 1),
                Arguments.of(new int[]{1, 3}, 2, -1),
                Arguments.of(new int[]{3, 1}, 1, 1),
                Arguments.of(new int[]{3, 1}, 3, 0),
                Arguments.of(new int[]{3, 1}, 2, -1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 1, 5),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 2, 6),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 4, 0),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 5, 1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 6, 2),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 7, 3)
        );
    }
}