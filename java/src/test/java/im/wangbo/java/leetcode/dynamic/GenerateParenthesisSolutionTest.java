package im.wangbo.java.leetcode.dynamic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class GenerateParenthesisSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int n, final String[] expected) {
        final GenerateParenthesisSolution s = new GenerateParenthesisSolution();

        final List<String> result = s.generateParenthesis(n);

        Assertions.assertThat(result).containsExactlyInAnyOrder(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(3, new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"}),
                Arguments.of(1, new String[]{"()"}),
                Arguments.of(0, new String[]{})
        );
    }
}