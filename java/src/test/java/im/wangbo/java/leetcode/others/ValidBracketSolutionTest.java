package im.wangbo.java.leetcode.others;

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
class ValidBracketSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final String a, final boolean expected) {
        final ValidBracketSolution s = new ValidBracketSolution();

        final boolean result = s.isValid(a);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("{[]}", true),
                Arguments.of("([)]", false),
                Arguments.of("(]", false),
                Arguments.of("()[]{}", true),
                Arguments.of("", true),
                Arguments.of("()", true)
        );
    }
}