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
class StringFirstUniqCharSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final String value, final int expected) {
        final StringFirstUniqCharSolution s = new StringFirstUniqCharSolution();

        final int result = s.firstUniqChar(value);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("leetcode", 0),
                Arguments.of("loveleetcode", 2)
        );
    }
}