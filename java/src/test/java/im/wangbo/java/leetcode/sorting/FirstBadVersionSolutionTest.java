package im.wangbo.java.leetcode.sorting;

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
class FirstBadVersionSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int n, int expected) {
        final FirstBadVersionSolution s = new FirstBadVersionSolution();

        FirstBadVersionSolution.TARGET = expected;
        final int result = s.firstBadVersion(n);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE, 10),
                Arguments.of(1, 1),
                Arguments.of(100, 0)
        );
    }
}