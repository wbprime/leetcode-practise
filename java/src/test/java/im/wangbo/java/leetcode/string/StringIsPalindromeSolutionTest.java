package im.wangbo.java.leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import im.wangbo.java.leetcode.string.StringIsPalindromeSolution;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class StringIsPalindromeSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final String a, final boolean expected) {
        final StringIsPalindromeSolution s = new StringIsPalindromeSolution();

        final boolean result = s.isPalindrome(a);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of("anagram", false),
                Arguments.of("rat", false)
        );
    }
}