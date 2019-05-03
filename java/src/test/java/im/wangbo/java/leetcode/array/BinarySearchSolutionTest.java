package im.wangbo.java.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import im.wangbo.java.leetcode.array.BinarySearchSolution;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class BinarySearchSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int target, final int expected) {
        final BinarySearchSolution s = new BinarySearchSolution();
        final int result = s.search(arr, target);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                // Array, target, expected index
                Arguments.of(new int[]{0, 1, 2, 4, 5, 6, 7}, 0, 0),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 6, 7}, 1, 1),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 6, 7}, 2, 2),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 6, 7}, 3, -1),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 6, 7}, 4, 3),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 6, 7}, 5, 4),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 6, 7}, 6, 5),
                Arguments.of(new int[]{0, 1, 2, 4, 5, 6, 7}, 7, 6)
        );
    }
}