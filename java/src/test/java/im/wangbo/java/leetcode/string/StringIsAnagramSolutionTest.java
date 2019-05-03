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
class StringIsAnagramSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final String a, final String b, final boolean expected) {
        final StringIsAnagramSolution s = new StringIsAnagramSolution();

        final boolean result = s.isAnagram(a, b);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }
}