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
class ClimbStairsSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int n, int expected) {
        final ClimbStairsSolution s = new ClimbStairsSolution();

        final int result = s.climbStairs(n);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(44, 1134903170),
                Arguments.of(2, 2),
                Arguments.of(1, 1),
                Arguments.of(0, 0)
        );
    }
}