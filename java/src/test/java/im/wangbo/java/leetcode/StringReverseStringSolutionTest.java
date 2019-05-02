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
class StringReverseStringSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final char[] arr, final char[] expected) {
        final StringReverseStringSolution s = new StringReverseStringSolution();

        s.reverseString(arr);

        Assertions.assertThat(arr).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new char[]{'h', 'e', 'h', 'h', 'o'}, new char[]{'o', 'h', 'h', 'e', 'h'}),
                Arguments.of(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}, new char[]{'h', 'a', 'n', 'n', 'a', 'H'})
        );
    }
}