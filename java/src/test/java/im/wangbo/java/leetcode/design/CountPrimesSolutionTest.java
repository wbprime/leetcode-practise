package im.wangbo.java.leetcode.design;

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
class CountPrimesSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int a, final int expected) {
        final CountPrimesSolution s = new CountPrimesSolution();

        final int result = s.countPrimes(a);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(10, 4),
                Arguments.of(3, 1)
        );
    }
}