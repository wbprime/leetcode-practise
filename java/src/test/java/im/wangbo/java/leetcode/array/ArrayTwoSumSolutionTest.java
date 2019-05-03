package im.wangbo.java.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import im.wangbo.java.leetcode.array.ArrayTwoSumSolution;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class ArrayTwoSumSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int target, final int[] expected) {
        final ArrayTwoSumSolution s = new ArrayTwoSumSolution();

        final int[] result = s.twoSum(arr, target);

        Assertions.assertThat(result).containsExactly(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, 4, new int[]{1, 2}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1})
        );
    }
}