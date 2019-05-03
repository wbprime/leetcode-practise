package im.wangbo.java.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import im.wangbo.java.leetcode.array.ArrayContainsDuplicateSolution;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class ArrayContainsDuplicateSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final boolean expected) {
        final ArrayContainsDuplicateSolution s = new ArrayContainsDuplicateSolution();

        final boolean result = s.containsDuplicate(arr);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, false),
                Arguments.of(new int[]{1, 1, 3, 4, 5, 6, 7}, true),
                Arguments.of(new int[]{1, 2, 2, 4, 5, 6, 7}, true),
                Arguments.of(new int[]{1, 2, 3, 3, 5, 6, 7}, true),
                Arguments.of(new int[]{1, 2, 3, 4, 4, 6, 7}, true),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 5, 7}, true),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 6}, true),
                Arguments.of(new int[]{7, 2, 3, 4, 5, 6, 7}, true),
                Arguments.of(new int[]{7, 6, 5, 4, 3, 2, 1}, false)
        );
    }
}