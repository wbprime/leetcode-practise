package im.wangbo.java.leetcode;

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
class ReverseWordsSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final String str, final String expected) {
        final ReverseWordsSolution s = new ReverseWordsSolution();
        final String result = s.reverseWords(str);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world!  ", "world! hello"),
                Arguments.of("a good   example", "example good a")
        );
    }
}