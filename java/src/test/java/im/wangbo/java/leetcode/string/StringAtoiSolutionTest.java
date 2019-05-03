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
class StringAtoiSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final String a, final int expected) {
        final StringAtoiSolution s = new StringAtoiSolution();

        final int result = s.myAtoi(a);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("-5-", -5),
                Arguments.of("5-0", 5),
                Arguments.of("-91283472332", -2147483648),
                Arguments.of("words and 987", 0),
                Arguments.of("4193 with words", 4193),
                Arguments.of("     -42", -42),
                Arguments.of("42", 42),
                Arguments.of("A man, a plan, a canal: Panama", 0),
                Arguments.of("rat", 0)
        );
    }
}