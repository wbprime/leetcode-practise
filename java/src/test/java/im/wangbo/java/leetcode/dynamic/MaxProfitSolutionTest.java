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
class MaxProfitSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int expected) {
        final MaxProfitSolution s = new MaxProfitSolution();
        final int result = s.maxProfit(arr);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4)
        );
    }
}