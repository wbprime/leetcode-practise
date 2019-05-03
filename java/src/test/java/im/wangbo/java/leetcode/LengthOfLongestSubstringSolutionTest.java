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
class LengthOfLongestSubstringSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final String str, final int expectedLen) {
        final LengthOfLongestSubstringSolution s = new LengthOfLongestSubstringSolution();
        final int result = s.lengthOfLongestSubstring(str);

        Assertions.assertThat(result).isEqualTo(expectedLen);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("pwwkew", 3),
                Arguments.of("bbbbb", 1)
        );
    }
}