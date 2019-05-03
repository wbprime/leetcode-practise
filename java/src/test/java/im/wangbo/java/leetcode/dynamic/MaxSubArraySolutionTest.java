package im.wangbo.java.leetcode.dynamic;

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
class MaxSubArraySolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int expected) {
        final MaxSubArraySolution s = new MaxSubArraySolution();
        final int result = s.maxSubArray(arr);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6),
                Arguments.of(new int[]{1, 2, 3}, 6)
        );
    }
}