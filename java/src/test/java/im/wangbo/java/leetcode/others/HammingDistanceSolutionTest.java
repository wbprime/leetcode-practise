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
class HammingDistanceSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int a, final int b, final int expected) {
        final HammingDistanceSolution s = new HammingDistanceSolution();

        final int result = s.hammingDistance(a, b);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, 4, 2)
        );
    }
}