package im.wangbo.java.leetcode.string;

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
class StringReverseIntSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int value, final int expected) {
        final StringReverseIntSolution s = new StringReverseIntSolution();

        final int result = s.reverse(value);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(-2147483648, 0),
                Arguments.of(1534236469, 0),
                Arguments.of(123, 321),
                Arguments.of(120, 21),
                Arguments.of(-123, -321)
        );
    }
}