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
class RobSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int expected) {
        final RobSolution s = new RobSolution();
        final int result = s.rob(arr);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 11, 3}, 11),
                Arguments.of(new int[]{11, 3}, 11),
                Arguments.of(new int[]{11}, 11),
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
        );
    }
}